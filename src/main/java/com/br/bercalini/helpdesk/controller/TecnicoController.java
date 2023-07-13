package com.br.bercalini.helpdesk.controller;

import com.br.bercalini.helpdesk.dto.TecnicoDTO;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.br.bercalini.helpdesk.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable(name = "id") Long id) {
        TecnicoDTO tecnicoDTO = tecnicoService.findById(id);
        return ResponseEntity.ok().body(tecnicoDTO);
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        List<Tecnico> tecnicos = tecnicoService.findAll();
        List<TecnicoDTO> tecnicoDTOS = tecnicos.stream().map(t -> new TecnicoDTO(t)).collect(Collectors.toList());
        return ResponseEntity.ok().body(tecnicoDTOS);
    }

}
