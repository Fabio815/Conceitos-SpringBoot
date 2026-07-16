package com.cursojava.pmanager.infrastructure.exeception;

import lombok.Getter;

@Getter
public class RequestException extends RuntimeException {
    private final String codigoErro;

    public RequestException(String mensagem, String codigoErro) {
        super(mensagem);
        this.codigoErro = codigoErro;
    }
}
