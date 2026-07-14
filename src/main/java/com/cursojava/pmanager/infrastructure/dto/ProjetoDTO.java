package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.domain.model.StatusProjeto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjetoDTO {
    private final Long id;
    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;
    private final StatusProjeto status;

    public static ProjetoDTO criar(Projeto projetoDTO) {
        return new ProjetoDTO(
                projetoDTO.getId(),
                projetoDTO.getNome(),
                projetoDTO.getDescricao(),
                projetoDTO.getDataInicial(),
                projetoDTO.getDataFinal(),
                projetoDTO.getStatus()
        );
    }
}
