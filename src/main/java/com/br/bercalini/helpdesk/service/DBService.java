package com.br.bercalini.helpdesk.service;

import com.br.bercalini.helpdesk.enums.Perfil;
import com.br.bercalini.helpdesk.enums.Prioridade;
import com.br.bercalini.helpdesk.enums.Status;
import com.br.bercalini.helpdesk.model.Chamado;
import com.br.bercalini.helpdesk.model.Cliente;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.br.bercalini.helpdesk.repository.ChamadoRepository;
import com.br.bercalini.helpdesk.repository.ClienteRepository;
import com.br.bercalini.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Valdir Cezar");
        tecnico.setCpf("272.579.230-43");
        tecnico.setEmail("valdir@mail.com");
        tecnico.setSenha("123");
        tecnico.addPerfil(Perfil.ADMIN);

        Cliente cliente = new Cliente();
        cliente.setNome("Linus Torvalds");
        cliente.setCpf("584.106.520-30");
        cliente.setEmail("torvalds@mail.com");
        cliente.setSenha("123");
        cliente.addPerfil(Perfil.CLIENTE);

        Chamado chamado = Chamado.builder().tecnico(tecnico).observacoes("Primeiro Chamado").prioridade(Prioridade.MEDIA)
                .status(Status.ANDAMENTO).titulo("Chamado 1").cliente(cliente).build();

        tecnicoRepository.saveAll(Arrays.asList(tecnico));
        clienteRepository.saveAll(Arrays.asList(cliente));
        chamadoRepository.save(chamado);
    }

}
