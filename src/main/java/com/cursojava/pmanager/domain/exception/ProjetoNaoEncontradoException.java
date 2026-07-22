package com.cursojava.pmanager.domain.exception;

import com.cursojava.pmanager.infrastructure.exeception.RequestException;

public class ProjetoNaoEncontradoException extends RequestException {

    public ProjetoNaoEncontradoException(Long idProjeto) {
        super("Não existente " + idProjeto, "ProjetoNaoEncontrado");
    }
}
