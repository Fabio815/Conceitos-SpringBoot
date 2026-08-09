package com.cursojava.pmanager.domain.exception;

import com.cursojava.pmanager.infrastructure.exeception.RequestException;

public class MembroDuplicadoException extends RequestException {

    public MembroDuplicadoException(String mensagem, String codigoErro) {
        super(mensagem, codigoErro);
    }
}