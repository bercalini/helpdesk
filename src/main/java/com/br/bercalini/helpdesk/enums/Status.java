package com.br.bercalini.helpdesk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String descricao;

    public static Status toEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }
        for(Status p: Status.values()) {
            if(codigo.equals(p.codigo)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Status invalido");
    }

}
