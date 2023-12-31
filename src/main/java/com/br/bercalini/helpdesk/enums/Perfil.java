package com.br.bercalini.helpdesk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {
    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");

     Integer codigo;
     String descricao;

    public static Perfil toEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }
        for(Perfil p: Perfil.values()) {
            if(codigo.equals(p.codigo)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Perfil invalido");
    }

}
