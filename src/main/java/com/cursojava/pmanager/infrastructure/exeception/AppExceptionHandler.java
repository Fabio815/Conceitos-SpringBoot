package com.cursojava.pmanager.infrastructure.exeception;

import jakarta.servlet.Servlet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //Aqui é para definir para o spring que essa classe vai ficar responsável pelo tratamento de exceções.
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handlerGenericException (Exception ex, WebRequest request) {
        return handlerException(ex, null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<Object> handlerRequestException  (RequestException ex, WebRequest request) {
        return handlerException(ex, ex.getCodigoErro(), ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    public ResponseEntity<Object> handlerException (Exception ex, String codigoErro, String mensagemErro, HttpStatus statusErro, WebRequest request) {
        ServletWebRequest webRequest = (ServletWebRequest) request;//Basicamente para pegar o caminho do end-point que deu erro.
        return handleExceptionInternal(
                ex,
                RestError
                        .builder()
                        .codigoErro(codigoErro)
                        .mensagemErro(mensagemErro)
                        .status(statusErro.value())
                        .caminho(webRequest.getRequest().getRequestURI())
                        .build(),
                new HttpHeaders(),
                statusErro,
                request
        );
    }
}
