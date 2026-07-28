package com.cursojava.pmanager.domain.exception;

import com.cursojava.pmanager.infrastructure.exeception.RequestException;
import org.apache.catalina.connector.Request;

public class ProjetoDuplicadoException extends RequestException {
    public ProjetoDuplicadoException(String nomeProjeto) {
        super("Projeto duplicado " + nomeProjeto, "projetoDuplicado");
    }
}
