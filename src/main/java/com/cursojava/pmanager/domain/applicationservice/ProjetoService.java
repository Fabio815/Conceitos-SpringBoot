package com.cursojava.pmanager.domain.applicationservice;

import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.domain.model.StatusProjeto;
import com.cursojava.pmanager.domain.repository.ProjetoRepository;
import com.cursojava.pmanager.infrastructure.dto.SalvarDadosProjetoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjetoService {
    //private static final Logger LOGGER = LoggerFactory.getLogger(ProjetoService.class); È CONSIDERADO BOILPLATECODE ENTÃO USAMOS O @Slf4j...

    private final ProjetoRepository projetoRepository;

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
}
