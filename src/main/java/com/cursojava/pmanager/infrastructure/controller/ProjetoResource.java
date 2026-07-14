package com.cursojava.pmanager.infrastructure.controller;

import com.cursojava.pmanager.domain.applicationservice.ProjetoService;
import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.infrastructure.dto.ProjetoDTO;
import com.cursojava.pmanager.infrastructure.dto.SalvarDadosProjetoDTO;
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
    public ResponseEntity<ProjetoDTO> save(@RequestBody SalvarDadosProjetoDTO salvarDadosProjetoDTO){
        Projeto projeto = projetoService.criarProjeto(salvarDadosProjetoDTO);
        return ResponseEntity.created(URI.create("/projeto/" + projeto.getId())).body(ProjetoDTO.criar(projeto));
    }
}