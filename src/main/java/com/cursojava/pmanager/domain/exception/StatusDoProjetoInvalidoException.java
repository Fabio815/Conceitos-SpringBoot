package com.cursojava.pmanager.domain.exception;

import com.cursojava.pmanager.infrastructure.exeception.RequestException;

public class StatusDoProjetoInvalidoException extends RequestException {

    public StatusDoProjetoInvalidoException(String statusProjeto) {
        super("Status do projeto inválido " + statusProjeto, "statusProjetoInvalido");
    }
}
