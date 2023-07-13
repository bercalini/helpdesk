package com.br.bercalini.helpdesk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tecnico extends Pessoa{
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();
}
