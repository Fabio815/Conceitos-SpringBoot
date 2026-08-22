package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.entity.Task;
import com.cursojava.pmanager.domain.model.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class TaskDTO {
    private final Long id;
    private final String titulo;
    private final String descricao;
    private final Integer numerosDeDias;
    private final TaskStatus status;

    public static TaskDTO criar(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitulo(),
                task.getDescricao(),
                task.getNumerosDeDias(),
                task.getStatus()
        );
    }
}
