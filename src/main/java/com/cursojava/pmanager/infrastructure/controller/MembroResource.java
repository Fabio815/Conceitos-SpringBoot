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

}
