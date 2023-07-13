package com.br.bercalini.helpdesk.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TecnicoDTO {
    private Long id;
    private String nome;
    private   String cpf;
    private String email;
    private String senha;
    private Set<String> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    private List<ChamandoTecDTO> chamados = new ArrayList<>();
}
