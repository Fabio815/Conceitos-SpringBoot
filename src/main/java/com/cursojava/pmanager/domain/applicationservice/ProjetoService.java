package com.cursojava.pmanager.domain.applicationservice;

import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.domain.model.StatusProjeto;
import com.cursojava.pmanager.domain.repository.ProjetoRepository;
import com.cursojava.pmanager.infrastructure.dto.SalvarDadosProjetoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoService {
    private final ProjetoRepository projetoRepository;

    public Projeto criarProjeto(SalvarDadosProjetoDTO salvarDadosProjeto) {
        Projeto projeto = Projeto.builder()
                .nome(salvarDadosProjeto.getNome())
                .descricao(salvarDadosProjeto.getDescricao())
                .dataInicial(salvarDadosProjeto.getDataInicial())
                .dataFinal(salvarDadosProjeto.getDataFinal())
                .status(StatusProjeto.PENDENTE).build();

        projetoRepository.save(projeto);
        return projeto;
    }
}
