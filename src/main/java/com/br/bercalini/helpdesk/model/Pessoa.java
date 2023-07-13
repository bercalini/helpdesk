package com.br.bercalini.helpdesk.model;

import com.br.bercalini.helpdesk.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public abstract class Pessoa {
    protected Long id;
    protected String nome;
    protected  String cpf;
    protected String email;
    protected String senha;
    protected Set<Integer> perfis = new HashSet<>();
    protected LocalDate data = LocalDate.now();

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfil() {
        return perfis.stream().map(p -> Perfil.toEnum(p)).collect(Collectors.toSet());
    }

}
