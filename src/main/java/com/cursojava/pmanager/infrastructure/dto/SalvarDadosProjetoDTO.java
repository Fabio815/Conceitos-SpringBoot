package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.model.StatusProjeto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SalvarDadosProjetoDTO {
    private final String nome;
    private final String descricao;
    private final LocalDateTime dataInicial;
    private final LocalDateTime dataFinal;
    private final String status;
}
