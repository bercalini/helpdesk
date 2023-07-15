package com.br.bercalini.helpdesk.dto;

import com.br.bercalini.helpdesk.model.Chamado;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChamadoDTO {

    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    @NotNull(message = "prioridade é obrigatório")
    private Integer prioridade;
    @NotNull(message = "status é obrigatório")
    private Integer status;
    @NotNull(message = "titulo é obrigatório")
    private String titulo;
    @NotNull(message = "obrigação é obrigatório")
    private String observacoes;
    private Long tecnico;
    private Long cliente;
    private String nomeTecnico;
    private String nomeCliente;

    public ChamadoDTO(Chamado chamado) {
        this.id = chamado.getId();
        this.cliente = chamado.getCliente().getId();
        this.dataAbertura = chamado.getDataAbertura();
        this.status = chamado.getStatus().getCodigo();
        this.observacoes = chamado.getObservacoes();
        this.prioridade = chamado.getPrioridade().getCodigo();
        this.tecnico = chamado.getTecnico().getId();
        this.titulo = chamado.getTitulo();
        this.nomeTecnico = chamado.getTecnico().getNome();
        this.nomeCliente = chamado.getCliente().getNome();
    }
}
