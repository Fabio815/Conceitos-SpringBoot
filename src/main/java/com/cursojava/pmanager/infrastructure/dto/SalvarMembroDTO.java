package com.cursojava.pmanager.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SalvarMembroDTO {

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 1, max = 80, message = "Nome não válido")
    private final String nome;

    @NotNull(message = "Email não pode ser nulo")
    @Email(message = "Email não é válido")
    private final String email;
}
