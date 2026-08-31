package com.cursojava.pmanager.domain.applicationservice;

import com.cursojava.pmanager.domain.entity.Task;
import com.cursojava.pmanager.domain.exception.StatusDaTaskInvalidoException;
import com.cursojava.pmanager.domain.exception.TaskNaoEncontradaException;
import com.cursojava.pmanager.domain.model.TaskStatus;
import com.cursojava.pmanager.domain.repository.TaskRepository;
import com.cursojava.pmanager.infrastructure.dto.SalvarTaskDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    @Transactional
    public Task criarTask(SalvarTaskDTO salvarTaskDTO) {
        Task task = Task.builder()
                .titulo(salvarTaskDTO.getTitulo())
                .descricao(salvarTaskDTO.getDescricao())
                .numerosDeDias(salvarTaskDTO.getNumeroDeDias())
                .status(TaskStatus.PENDENTE)
                .build();

        taskRepository.save(task);
        return task;
    }

    public Task carregarTask(Long id) {
        /*Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new TaskNaoEncontradaException(id);
        }

        return task.get();*/
        return taskRepository
                .findById(id)
                .orElseThrow(() -> new TaskNaoEncontradaException(id));
    }

    @Transactional
    public void deletarTask(Long id) {
        Task task = carregarTask(id);
        taskRepository.delete(task);
    }

    @Transactional
    public Task atualizarTask(Long id, SalvarTaskDTO salvarTaskDTO) {
        Task task = carregarTask(id);

        task.setTitulo(salvarTaskDTO.getTitulo());
        task.setDescricao(salvarTaskDTO.getDescricao());
        task.setNumerosDeDias(salvarTaskDTO.getNumeroDeDias());
        task.setStatus(converterParaTaskStatus(salvarTaskDTO.getStatus()));

        return task;
    }

    private TaskStatus converterParaTaskStatus(String taskStatus) {
        try {
            return TaskStatus.valueOf(taskStatus);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new StatusDaTaskInvalidoException(taskStatus);
        }
    }
}
