package com.br.bercalini.helpdesk.model;

import com.br.bercalini.helpdesk.dto.TecnicoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Tecnico extends Pessoa{
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(TecnicoDTO tecnicoDTO) {
        super();
        this.id = tecnicoDTO.getId();
        this.cpf = tecnicoDTO.getCpf();
        this.data = tecnicoDTO.getData();
        this.nome = tecnicoDTO.getNome();
        this.email = tecnicoDTO.getEmail();
        this.senha = tecnicoDTO.getSenha();
        this.perfis = tecnicoDTO.getPerfis().stream().map(t -> t.getCodigo()).collect(Collectors.toSet());
    }

}
