package com.cursojava.pmanager.infrastructure.controller;

import com.cursojava.pmanager.domain.applicationservice.TaskService;
import com.cursojava.pmanager.domain.entity.Task;
import com.cursojava.pmanager.infrastructure.dto.SalvarTaskDTO;
import com.cursojava.pmanager.infrastructure.dto.TaskDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskResource {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> salvarTask(@RequestBody @Valid SalvarTaskDTO salvarTaskDTO) {
        Task task = taskService.criarTask(salvarTaskDTO);
        return ResponseEntity.created(URI.create("/task/" + task.getId())).body(TaskDTO.criar(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> carregarTask(@PathVariable("id") Long id) {
        Task task = taskService.carregarTask(id);
        return ResponseEntity.ok(TaskDTO.criar(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTask(@PathVariable("id") Long id) {
        taskService.deletarTask(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> atualizarTask(@PathVariable("id") Long id, @RequestBody @Valid SalvarTaskDTO taskDTO) {
        Task task = taskService.atualizarTask(id, taskDTO);
        return ResponseEntity.ok(TaskDTO.criar(task));
    }
}
