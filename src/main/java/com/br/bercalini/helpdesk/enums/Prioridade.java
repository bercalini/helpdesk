package com.br.bercalini.helpdesk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Prioridade {
    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

    private Integer codigo;
    private String descricao;

    public static Prioridade toEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }
        for(Prioridade p: Prioridade.values()) {
            if(codigo.equals(p.codigo)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Prioridade invalido");
    }

}
