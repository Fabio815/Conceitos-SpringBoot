package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.entity.Membro;
import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.domain.model.StatusProjeto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ProjetoDTO {
    private final Long id;
    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;
    private final StatusProjeto status;
    private final Set<Long> membrosIds;

    public static ProjetoDTO criar(Projeto projeto) {
        return new ProjetoDTO(
                projeto.getId(),
                projeto.getNome(),
                projeto.getDescricao(),
                projeto.getDataInicial(),
                projeto.getDataFinal(),
                projeto.getStatus(),
                Optional.ofNullable(projeto.getMembros())
                        .orElse(List.of())
                        .stream()
                        .map(Membro::getId)
                        .collect(Collectors.toSet())
        );
    }
}
