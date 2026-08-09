package com.cursojava.pmanager.infrastructure.controller;

import com.cursojava.pmanager.domain.applicationservice.MembroService;
import com.cursojava.pmanager.domain.applicationservice.ProjetoService;
import com.cursojava.pmanager.domain.entity.Membro;
import com.cursojava.pmanager.infrastructure.dto.MembroDTO;
import com.cursojava.pmanager.infrastructure.dto.ProjetoDTO;
import com.cursojava.pmanager.infrastructure.dto.SalvarMembroDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/membro")
public class MembroResource {
    private final MembroService membroService;

    @PostMapping
    public ResponseEntity<MembroDTO> adicionarMembro(@RequestBody @Valid SalvarMembroDTO salvarMembroDTO) {
        Membro membro = membroService.criarMembro(salvarMembroDTO);
        return ResponseEntity.created(URI.create("/membro/" + membro.getId())).body(MembroDTO.criarMembro(membro));
    }

    @GetMapping("{id}")
    public ResponseEntity<MembroDTO> carregarMembro(@PathVariable("id") Long id) {
        Membro membro = membroService.carregarMembroPorId(id);
        return ResponseEntity.ok(MembroDTO.criarMembro(membro));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> desativarMembro(@PathVariable("id") Long id) {
        membroService.desativarMembro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<MembroDTO> atualizarMembro(@PathVariable("id") Long id, @RequestBody @Valid SalvarMembroDTO salvarMembroDTO) {
        Membro membro = membroService.atualizarMembro(id, salvarMembroDTO);
        return ResponseEntity.ok(MembroDTO.criarMembro(membro));
    }

    @GetMapping
    public ResponseEntity<List<MembroDTO>> listarMembros(@RequestParam(value = "email", required = false) String email) {
        List<Membro> membros = membroService.listarMembros(email);
        return ResponseEntity.ok(membros.stream().map(MembroDTO::criarMembro).toList());
    }
}
