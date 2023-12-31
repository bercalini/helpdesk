package com.br.bercalini.helpdesk.controller;

import com.br.bercalini.helpdesk.dto.TecnicoDTO;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.br.bercalini.helpdesk.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = tecnicoService.created(tecnicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoDTO> update(@PathVariable Long id, @Valid @RequestBody TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = tecnicoService.update(id, tecnicoDTO);
        return ResponseEntity.ok().body(new TecnicoDTO(tecnico));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        tecnicoService.delete(id);
    }


}
