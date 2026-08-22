package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.entity.Task;
import com.cursojava.pmanager.domain.model.TaskStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SalvarTaskDTO {
    @NotNull(message = "Título não estar vazio")
    private final String titulo;

    @NotNull(message = "Descrição não pode estar vazio")
    @Size(min = 1, max = 150, message = "Descrição inválida")
    private final String descricao;

    @NotNull
    @Positive(message = "O número deve ser positivo")
    private final Integer numeroDeDias;

    private final TaskStatus status;
}
