package com.cursojava.pmanager.domain.applicationservice;

import com.cursojava.pmanager.domain.entity.Membro;
import com.cursojava.pmanager.domain.exception.MembroDuplicadoException;
import com.cursojava.pmanager.domain.exception.MembroNaoEncontradoException;
import com.cursojava.pmanager.domain.repository.MembroRepository;
import com.cursojava.pmanager.infrastructure.dto.SalvarMembroDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.rmi.server.LogStream.log;

@Service
@AllArgsConstructor
@Slf4j
public class MembroService {
    private final MembroRepository membroRepository;

    @Transactional
    public Membro criarMembro(SalvarMembroDTO salvarMembroDTO) {
        if (existsMembroComEmail(salvarMembroDTO.getEmail(), null)) {
            throw new MembroDuplicadoException("Email já existente", "emailduplicado");
        }

        Membro membro = Membro.builder()
                .nome(salvarMembroDTO.getNome())
                .secreto(UUID.randomUUID().toString())
                .email(salvarMembroDTO.getEmail())
                .desativo(false)
                .build();

        membroRepository.save(membro);
        return membro;
    }

    public Membro carregarMembroPorId(Long id) {
        Optional<Membro> op = membroRepository.findByIdAndDesativo(id, false);
        if (op.isEmpty()) {
            throw new MembroNaoEncontradoException(id);
        }

        return op.get();
    }

    @Transactional
    public void desativarMembro(Long id) {
        Membro membro = carregarMembroPorId(id);
        membro.setDesativo(true);
    }

    @Transactional
    public Membro atualizarMembro(Long id, SalvarMembroDTO salvarMembroDTO) {
        if (existsMembroComEmail(salvarMembroDTO.getEmail(), id)) {
            throw new MembroDuplicadoException("Email já existente", "emailduplicado");
        }

        Membro membro = carregarMembroPorId(id);
        membro.setNome(salvarMembroDTO.getNome());
        membro.setEmail(salvarMembroDTO.getEmail());

        return membro;
    }

    public List<Membro> listarMembros(String email) {
        List<Membro> listaMembros = null;
        if (email.isEmpty()) {
            listaMembros = membroRepository.findAll();
        } else {
            Optional<Membro> op = membroRepository.findByEmailAndDesativo(email, false);
            if (op.isPresent()) {
                listaMembros = List.of(op.get());
            } else {
                listaMembros = List.of();
            }
            /*listaMembros = membroRepository.findByEmailAndDesativo(email, false)
                    .map(m -> List.of(m))
                    .orElse(List.of());*/
        }

        return listaMembros;
    }

    //Na hora de fazer a atulização não posso comparar ele com ele mesmo, por isso tenho o idExcluido.
    private boolean existsMembroComEmail(String email, Long idExcluido) {
        return membroRepository.findByEmailAndDesativo(email, false)//Aqui estou procurando se já não tem um email igual.
                .filter(e -> !Objects.equals(e.getId(), idExcluido)).isPresent();//So vou ficar com o membro se o id for diferente do idEcluido
    }
}