package com.cursojava.pmanager.infrastructure.controller;

import com.cursojava.pmanager.domain.applicationservice.TaskService;
import com.cursojava.pmanager.domain.entity.Task;
import com.cursojava.pmanager.infrastructure.dto.SalvarTaskDTO;
import com.cursojava.pmanager.infrastructure.dto.TaskDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskResource {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> salvar(@RequestBody @Valid SalvarTaskDTO salvarTaskDTO) {
        Task task = taskService.criarTask(salvarTaskDTO);
        return ResponseEntity.created(URI.create("/task/" + task.getId())).body(TaskDTO.criar(task));
    }
}
