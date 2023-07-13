package com.br.bercalini.helpdesk.service.exeception;

public class ObjetoNaoEncontrado extends RuntimeException {

    public ObjetoNaoEncontrado(String mensagem) {
        super(mensagem);
    }

    public ObjetoNaoEncontrado(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }


}
