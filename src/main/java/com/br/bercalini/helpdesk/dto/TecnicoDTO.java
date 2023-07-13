package com.br.bercalini.helpdesk.dto;

import com.br.bercalini.helpdesk.enums.Perfil;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Data
public class TecnicoDTO {
    private Long id;
    private String nome;
    private   String cpf;
    private String email;
    private String senha;
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;


    public TecnicoDTO() {
        super();
    }
    public TecnicoDTO(Tecnico tecnico) {
        super();
        this.id = tecnico.getId();
        this.cpf = tecnico.getCpf();
        this.data = tecnico.getData();
        this.nome = tecnico.getNome();
        this.email = tecnico.getEmail();
        this.senha = tecnico.getSenha();
        this.perfis = tecnico.getPerfil().stream().map(t -> t.getCodigo()).collect(Collectors.toSet());
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(p -> Perfil.toEnum(p)).collect(Collectors.toSet());
    }
}
