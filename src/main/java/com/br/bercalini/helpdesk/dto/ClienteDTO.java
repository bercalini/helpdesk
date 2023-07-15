package com.br.bercalini.helpdesk.dto;

import com.br.bercalini.helpdesk.enums.Perfil;
import com.br.bercalini.helpdesk.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Data
public class ClienteDTO {
    private Long id;
    @NotNull(message = "O campo nome é obrigatório")
    private String nome;
    @NotNull(message = "O campo cpf é obrigatório")
    private String cpf;
    @NotNull(message = "O campo email é obrigatório")
    private String email;
    @NotNull(message = "O campo senha é obrigatório")
    private String senha;
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;


    public ClienteDTO() {
        super();
    }
    public ClienteDTO(Cliente cliente) {
        super();
        this.id = cliente.getId();
        this.cpf = cliente.getCpf();
        this.data = cliente.getData();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.perfis = cliente.getPerfil().stream().map(t -> t.getCodigo()).collect(Collectors.toSet());
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(p -> Perfil.toEnum(p)).collect(Collectors.toSet());
    }
}
