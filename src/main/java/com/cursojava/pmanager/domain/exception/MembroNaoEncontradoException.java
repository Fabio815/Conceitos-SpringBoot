package com.cursojava.pmanager.domain.exception;

import com.cursojava.pmanager.infrastructure.exeception.RequestException;

public class MembroNaoEncontradoException extends RequestException {

    public MembroNaoEncontradoException(Long id) {
        super("Membro não encontrado id: " + id, "MembroNaoEncontrado");
    }
}
