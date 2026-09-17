package com.cursojava.pmanager.infrastructure.dto;

import com.cursojava.pmanager.domain.entity.Task;
import com.cursojava.pmanager.domain.model.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;

@Data
public class TaskDTO {
    private final Long id;
    private final String titulo;
    private final String descricao;
    private final Integer numerosDeDias;
    private final TaskStatus status;
    private final ProjetoDTO projeto;
    private final MembroDTO assigedMembro;

    public static TaskDTO criar(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitulo(),
                task.getDescricao(),
                task.getNumerosDeDias(),
                task.getStatus(),
                Optional.ofNullable(task.getProjeto()).map(p -> ProjetoDTO.criar(p)).orElse(null),
                Optional.ofNullable(task.getAssigedMembro()).map(m -> MembroDTO.criarMembro(m)).orElse(null)
        );
    }
}
