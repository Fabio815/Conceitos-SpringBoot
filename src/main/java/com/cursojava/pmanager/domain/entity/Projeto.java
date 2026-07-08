package com.cursojava.pmanager.domain.entity;

import com.cursojava.pmanager.domain.model.StatusProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {
    private String id;
    private String nome;
    private String descricao;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    private StatusProjeto status;
}