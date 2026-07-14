package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.model.StatusProjeto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SalvarDadosProjetoDTO {
    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;
    private final String status;
}
