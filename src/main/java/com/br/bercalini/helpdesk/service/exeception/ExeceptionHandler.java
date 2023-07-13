package com.br.bercalini.helpdesk.service.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExeceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontrado.class)
    public ResponseEntity<StantardError> objetoNaoEncontradoExeception(ObjetoNaoEncontrado ex, HttpServletRequest request) {
        StantardError stantardError = new StantardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "Objeto não encontrado", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stantardError);
    }
}
