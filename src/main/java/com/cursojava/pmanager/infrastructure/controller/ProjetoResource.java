package com.cursojava.pmanager.infrastructure.controller;

import com.cursojava.pmanager.domain.applicationservice.ProjetoService;
import com.cursojava.pmanager.domain.entity.Projeto;
import com.cursojava.pmanager.infrastructure.dto.SalvarDadosProjetoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProjetoResource {
    private final ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Projeto> save(@RequestBody SalvarDadosProjetoDTO projeto){
        Projeto projetoSalvo = projetoService.criarProjeto(projeto);
        return ResponseEntity.created(URI.create("/projeto/" + projeto.getNome())).body(projetoSalvo);
    }
}
