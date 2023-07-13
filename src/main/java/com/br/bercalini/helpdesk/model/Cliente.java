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
public class Cliente extends Pessoa{
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();
}
