package com.cursojava.pmanager.domain.applicationservice;

import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.domain.exception.ProjetoNaoEncontradoException;
import com.cursojava.pmanager.domain.model.StatusProjeto;
import com.cursojava.pmanager.domain.repository.ProjetoRepository;
import com.cursojava.pmanager.infrastructure.dto.SalvarDadosProjetoDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjetoService {
    //private static final Logger LOGGER = LoggerFactory.getLogger(ProjetoService.class); È CONSIDERADO BOILPLATECODE ENTÃO USAMOS O @Slf4j...

    private final ProjetoRepository projetoRepository;

    @Transactional
    public Projeto criarProjeto(SalvarDadosProjetoDTO salvarDadosProjeto) {
        Projeto projeto = Projeto.builder()
                .nome(salvarDadosProjeto.getNome())
                .descricao(salvarDadosProjeto.getDescricao())
                .dataInicial(salvarDadosProjeto.getDataInicial())
                .dataFinal(salvarDadosProjeto.getDataFinal())
                .status(StatusProjeto.PENDENTE).build();

        projetoRepository.save(projeto);
        log.info("Projeto Criado com sucesso! {}",  projeto);
        return projeto;
    }

    public Projeto carregarProjeto(Long idProjeto) {
        /*Optional<Projeto> op = projetoRepository.findById(idProjeto);
        if (op.isEmpty()) {
            throw new ProjetoNaoEncontradoException(idProjeto);
        }
        return op.get();*/

        return projetoRepository.findById(idProjeto).orElseThrow(() -> new ProjetoNaoEncontradoException(idProjeto));
    }

    @Transactional
    public void deletarProjeto(Long idProjeto) {
        Projeto projeto = carregarProjeto(idProjeto);
        projetoRepository.delete(projeto);
    }
}