package com.cursojava.pmanager.domain.applicationservice;

import com.cursojava.pmanager.domain.entity.Membro;
import com.cursojava.pmanager.domain.exception.MembroNaoEncontradoException;
import com.cursojava.pmanager.domain.repository.MembroRepository;
import com.cursojava.pmanager.infrastructure.dto.SalvarMembroDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MembroService {
    private final MembroRepository membroRepository;

    @Transactional
    public Membro criarMembro(SalvarMembroDTO salvarMembroDTO) {
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
        Membro membro = carregarMembroPorId(id);
        membro.setNome(salvarMembroDTO.getNome());
        membro.setEmail(salvarMembroDTO.getEmail());

        return membro;
    }
}