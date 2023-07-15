package com.br.bercalini.helpdesk.controller;

import com.br.bercalini.helpdesk.dto.ChamadoDTO;
import com.br.bercalini.helpdesk.model.Chamado;
import com.br.bercalini.helpdesk.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Long id) {
        Chamado chamado = chamadoService.findById(id);
        return ResponseEntity.ok().body(new ChamadoDTO(chamado));
    }

    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        List<Chamado> chamados = chamadoService.findAll();
        return ResponseEntity.ok().body(chamados.stream().map(c -> new ChamadoDTO(c)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO chamadoDTO) {
        Chamado chamado = chamadoService.create(chamadoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).body(new ChamadoDTO(chamado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoDTO> update(@PathVariable Long id, @Valid @RequestBody ChamadoDTO chamadoDTO) {
        Chamado chamado = chamadoService.update(id, chamadoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ChamadoDTO(chamado));
    }

}
