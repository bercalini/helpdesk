package com.br.bercalini.helpdesk.model;

import com.br.bercalini.helpdesk.enums.Prioridade;
import com.br.bercalini.helpdesk.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @CreationTimestamp
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String titulo;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;


}
