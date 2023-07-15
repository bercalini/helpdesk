package com.br.bercalini.helpdesk.controller;

import com.br.bercalini.helpdesk.dto.ClienteDTO;
import com.br.bercalini.helpdesk.model.Cliente;
import com.br.bercalini.helpdesk.service.ClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable(name = "id") Long id) {
        ClienteDTO clienteDTO = clienteService.findById(id);
        return ResponseEntity.ok().body(clienteDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clienteDTOS = clientes.stream().map(t -> new ClienteDTO(t)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clienteDTOS);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.created(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.update(id, clienteDTO);
        return ResponseEntity.ok().body(new ClienteDTO(cliente));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        clienteService.delete(id);
    }


}
