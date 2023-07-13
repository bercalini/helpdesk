package com.br.bercalini.helpdesk.model;

import com.br.bercalini.helpdesk.enums.Prioridade;
import com.br.bercalini.helpdesk.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chamado {
    private Long id;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;
    private Cliente cliente;
    private Tecnico tecnico;
}
