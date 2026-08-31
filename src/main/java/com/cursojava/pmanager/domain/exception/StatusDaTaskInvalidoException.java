package com.cursojava.pmanager.domain.exception;

import com.cursojava.pmanager.infrastructure.exeception.RequestException;

public class StatusDaTaskInvalidoException extends RequestException {
    public StatusDaTaskInvalidoException(String status) {
        super("Status inválido " + status, "statusinvalid");
    }
}
