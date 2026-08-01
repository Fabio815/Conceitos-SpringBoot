package com.cursojava.pmanager.domain.applicationservice;

import com.cursojava.pmanager.domain.entity.Membro;
import com.cursojava.pmanager.domain.repository.MembroRepository;
import com.cursojava.pmanager.infrastructure.dto.SalvarMembroDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MembroService {
    private final MembroRepository membroRepository;

    public Membro criarMembro(SalvarMembroDTO salvarMembroDTO) {
        Membro membro = Membro.builder()
                .nome(salvarMembroDTO.getNome())
                .secreto(UUID.randomUUID().toString())
                .email(salvarMembroDTO.getEmail())
                .desativo(false)
                .build();

        membroRepository.save(membro);
        return membro;
    }
}