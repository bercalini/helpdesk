package com.br.bercalini.helpdesk.service.exeception;

public class JdbcSQLIntegrityConstraintViolationException extends RuntimeException{
    public JdbcSQLIntegrityConstraintViolationException(String mensagem) {
        super(mensagem);
    }
}
