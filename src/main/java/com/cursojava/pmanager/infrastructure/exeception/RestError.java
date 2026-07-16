package com.cursojava.pmanager.infrastructure.exeception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestError {
    private final String codigoErro;
    private final String mensagemErro;
    private final int status;
    private final String caminho;
}
