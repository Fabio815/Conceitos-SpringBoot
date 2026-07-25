package com.cursojava.pmanager.infrastructure.controller;

import com.cursojava.pmanager.domain.applicationservice.ProjetoService;
import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.infrastructure.dto.ProjetoDTO;
import com.cursojava.pmanager.infrastructure.dto.SalvarDadosProjetoDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoResource {
    private final ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoDTO> save(@RequestBody @Valid SalvarDadosProjetoDTO salvarDadosProjetoDTO){
        Projeto projeto = projetoService.criarProjeto(salvarDadosProjetoDTO);
        return ResponseEntity.created(URI.create("/projeto/" + projeto.getId())).body(ProjetoDTO.criar(projeto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> consultar(@PathVariable Long id) {
        Projeto projeto = projetoService.carregarProjeto(id);
        return ResponseEntity.ok(ProjetoDTO.criar(projeto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}