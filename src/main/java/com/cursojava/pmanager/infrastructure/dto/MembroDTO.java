package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.entity.Membro;
import com.cursojava.pmanager.domain.entity.Projeto;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class MembroDTO {
    private final Long id;
    private final String nome;
    private final String email;
    private final String secreto;
    private final Set<Long> projetosIds;

    public static MembroDTO criarMembro(Membro membro) {
        return new MembroDTO(
                membro.getId(),
                membro.getNome(),
                membro.getEmail(),
                membro.getSecreto(),
                Optional.ofNullable(membro.getProjetos())
                        .orElse(List.of())
                        .stream()
                        .map(Projeto::getId)//m -> m.getId é a mesma coisa
                        .collect(Collectors.toSet())
        );
    }
}
