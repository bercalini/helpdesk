package com.br.bercalini.helpdesk.model;

import com.br.bercalini.helpdesk.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente extends Pessoa{
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente(ClienteDTO clienteDTO) {
        super();
        this.id = clienteDTO.getId();
        this.cpf = clienteDTO.getCpf();
        this.data = clienteDTO.getData();
        this.nome = clienteDTO.getNome();
        this.email = clienteDTO.getEmail();
        this.senha = clienteDTO.getSenha();
        this.perfis = clienteDTO.getPerfis().stream().map(t -> t.getCodigo()).collect(Collectors.toSet());
    }
}
