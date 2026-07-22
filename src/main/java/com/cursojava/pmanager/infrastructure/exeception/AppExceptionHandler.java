package com.cursojava.pmanager.infrastructure.exeception;

import jakarta.servlet.Servlet;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@ControllerAdvice //Aqui é para definir para o spring que essa classe vai ficar responsável pelo tratamento de exceções.
@Slf4j
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handlerGenericException (Exception ex, WebRequest request) {
        return handlerException(ex, null, ex.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<Object> handlerRequestException  (RequestException ex, WebRequest request) {
        return handlerException(ex, ex.getCodigoErro(), ex.getMessage(), null, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> listaErro = new ArrayList<>();
        //log.info("Aqui o erro {}", ex.getBindingResult().getFieldError().toString());
        //List<Object> teste = Collections.singletonList(ex.getBindingResult().getFieldError());
        for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
            listaErro.add(erro.getDefaultMessage());
        }
        return handlerException(ex, "Erro de validacao", null, listaErro, HttpStatus.BAD_REQUEST, request);
    }

    public ResponseEntity<Object> handlerException (Exception ex, String codigoErro, String mensagemErro, List<String> detalhes, HttpStatus statusErro, WebRequest request) {
        ServletWebRequest webRequest = (ServletWebRequest) request;//Basicamente para pegar o caminho do end-point que deu erro.
        return handleExceptionInternal(
                ex,
                RestError
                        .builder()
                        .codigoErro(codigoErro)
                        .mensagemErro(mensagemErro)
                        .status(statusErro.value())
                        .descricaoErro(detalhes)
                        .caminho(webRequest.getRequest().getRequestURI())
                        .build(),
                new HttpHeaders(),
                statusErro,
                request
        );
    }
}
/*
* handlerGenericException: trata erros inesperados da aplicação, geralmente problemas internos do servidor (bugs, falha no banco, erro de programação, etc.).
*
* handlerRequestException: Trata exceções personalizadas lançadas pela aplicação, quando alguma regra de negócio não é atendida, por exemplo.
*
* handleMethodArgumentNotValid: trata erros de validação dos dados enviados pelo cliente. Ocorre quando alguma anotação de validação (@NotBlank, @Size, @NotNull, etc.) não é respeitada.
* */