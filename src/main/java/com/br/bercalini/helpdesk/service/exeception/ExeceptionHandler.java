package com.br.bercalini.helpdesk.service.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StantardError> jdbcSQLIntegrityConstraintViolationException(JdbcSQLIntegrityConstraintViolationException ex, HttpServletRequest request) {
        StantardError stantardError = new StantardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "cpf já em uso no sistema", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stantardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StantardError> MethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setTimestamp(System.currentTimeMillis());
        validationError.setStatus(HttpStatus.BAD_REQUEST.value());
        validationError.setError("Violação de dados");
        validationError.setMessage("Violação de dados no campos obrigatórios");
        validationError.setPath(request.getRequestURI());

        for(FieldError x : ex.getBindingResult().getFieldErrors()) {
            validationError.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }

}
