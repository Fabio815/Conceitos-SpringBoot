package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.model.StatusProjeto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SalvarDadosProjetoDTO {
//Usando o beanValidation para verificar se a requisição respeita a entidade.
    @NotNull


    @Size(min = 1, max = 80)
    private final String nome;

    @NotNull
    @Size(min = 1, max = 150)
    private final String descricao;

    @NotNull
    private final LocalDate dataInicial;

    @NotNull
    private final LocalDate dataFinal;

    private final String status;
}
