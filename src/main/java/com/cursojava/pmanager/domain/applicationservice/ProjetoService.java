package com.cursojava.pmanager.domain.applicationservice;

import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.domain.model.StatusProjeto;
import com.cursojava.pmanager.infrastructure.dto.SalvarDadosProjetoDTO;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    public Projeto criarProjeto(SalvarDadosProjetoDTO salvarDadosProjetoDTO) {
        Projeto projeto = Projeto.builder()
                .nome(salvarDadosProjetoDTO.getNome())
                .descricao(salvarDadosProjetoDTO.getDescricao())
                .dataInicial(salvarDadosProjetoDTO.getDataInicial())
                .dataFinal(salvarDadosProjetoDTO.getDataFinal())
                .status(StatusProjeto.PENDENTE).build();

        return projeto;
    }
}
