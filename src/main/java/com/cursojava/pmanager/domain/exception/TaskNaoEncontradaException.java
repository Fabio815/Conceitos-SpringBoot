package com.cursojava.pmanager.domain.exception;

import com.cursojava.pmanager.infrastructure.exeception.RequestException;

public class TaskNaoEncontradaException extends RequestException {
    public TaskNaoEncontradaException(Long id) {
        super("Task não encontrada id: " + id, "tasknaoencontrada");
    }
}
