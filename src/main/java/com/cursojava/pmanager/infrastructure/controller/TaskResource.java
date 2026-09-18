package com.cursojava.pmanager.infrastructure.controller;

import com.cursojava.pmanager.domain.applicationservice.TaskService;
import com.cursojava.pmanager.domain.entity.Task;
import com.cursojava.pmanager.infrastructure.dto.SalvarTaskDTO;
import com.cursojava.pmanager.infrastructure.dto.TaskDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TaskDTO>> encontrarTasks(
            @RequestParam(value = "projectId", required = false) Long projetoId,
            @RequestParam(value = "membroId", required = false) Long membroId,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "tituloParcial", required = false) String tituloParcial) {
        Page<Task> tasks = taskService.encontrarTasks(projetoId, membroId, status, tituloParcial);

        return ResponseEntity.ok(tasks.stream().map(TaskDTO::criar).toList());
    }
}
