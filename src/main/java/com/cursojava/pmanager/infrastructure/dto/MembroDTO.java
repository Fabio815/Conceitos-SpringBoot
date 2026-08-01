package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.entity.Membro;
import lombok.Data;

@Data
public class MembroDTO {
    private final Long id;
    private final String nome;
    private final String email;
    private final String secreto;

    public static MembroDTO criarMembro(Membro membro) {
        return new MembroDTO(
                membro.getId(),
                membro.getNome(),
                membro.getEmail(),
                membro.getSecreto()
        );
    }
}
