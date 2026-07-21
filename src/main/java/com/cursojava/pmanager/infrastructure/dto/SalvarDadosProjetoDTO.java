package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.model.StatusProjeto;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SalvarDadosProjetoDTO {
//Usando o beanValidation para verificar se a requisição respeita a entidade.
    @NotNull(message = "O campo não pode ser vazio")
    @Size(min = 1, max = 80, message = "Nome maior que 80 caracteres")
    private final String nome;

    @NotNull(message = "O campo não pode ser vazio")
    @Size(min = 1, max = 150, message = "Descrição maior que 150 caracteres")
    private final String descricao;

    @NotNull(message = "O campo não pode ser vazio")
    private final LocalDate dataInicial;

    @NotNull(message = "O campo não pode ser vazio")
    private final LocalDate dataFinal;

    private final String status;

    @AssertTrue(message = "A data inicial deve ser anterior à data final")
    private boolean isDatasValidas() {
        return dataInicial.isBefore(dataFinal);
    }
}
