package com.br.bercalini.helpdesk.service;

import com.br.bercalini.helpdesk.enums.Perfil;
import com.br.bercalini.helpdesk.enums.Prioridade;
import com.br.bercalini.helpdesk.enums.Status;
import com.br.bercalini.helpdesk.model.Chamado;
import com.br.bercalini.helpdesk.model.Cliente;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.br.bercalini.helpdesk.repository.ChamadoRepository;
import com.br.bercalini.helpdesk.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Valdir Cezar");
        tecnico.setCpf("272.579.230-43");
        tecnico.setEmail("valdir@mail.com");
        tecnico.setSenha("123");
        tecnico.addPerfil(Perfil.ADMIN);
        tecnico.addPerfil(Perfil.TECNICO);

        Tecnico tecnico2 = new Tecnico();
        tecnico2.setNome("Richard Stallman");
        tecnico2.setCpf("903.347.070-65");
        tecnico2.setEmail("stallman@mail.com");
        tecnico2.setSenha("123");
        tecnico2.addPerfil(Perfil.TECNICO);

        Tecnico tecnico3 = new Tecnico();
        tecnico3.setNome("Claude Elwwod Shanoon");
        tecnico3.setCpf("271.068.470-54");
        tecnico3.setEmail("shanoon@mail.com");
        tecnico3.setSenha("123");
        tecnico3.addPerfil(Perfil.TECNICO);

        Tecnico tecnico4 = new Tecnico();
        tecnico4.setNome("Tim Berners-Lee");
        tecnico4.setCpf("162.720.120-39");
        tecnico4.setEmail("lee@mail.com");
        tecnico4.setSenha("123");
        tecnico4.addPerfil(Perfil.TECNICO);

        Tecnico tecnico5 = new Tecnico();
        tecnico2.setNome("Linus Torvalds");
        tecnico2.setCpf("778.556.170-27");
        tecnico2.setEmail("linus@mail.com");
        tecnico2.setSenha("123");
        tecnico2.addPerfil(Perfil.TECNICO);

        Cliente cliente = new Cliente();
        cliente.setNome("Linus Torvalds");
        cliente.setCpf("584.106.520-30");
        cliente.setEmail("torvalds@mail.com");
        cliente.setSenha("123");
        cliente.addPerfil(Perfil.CLIENTE);

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Marie Curie");
        cliente1.setCpf("332.429.140-06");
        cliente1.setEmail("curie@mail.com");
        cliente1.setSenha("123");
        cliente1.addPerfil(Perfil.CLIENTE);

        Cliente cliente2 = new Cliente();
        cliente1.setNome("Charles Darwin");
        cliente1.setCpf("792.043.830-62");
        cliente1.setEmail("darwin@mail.com");
        cliente1.setSenha("123");
        cliente1.addPerfil(Perfil.CLIENTE);

        Cliente cliente3 = new Cliente();
        cliente1.setNome("Max Planck");
        cliente1.setCpf("081.399.300-83");
        cliente1.setEmail("plack@mail.com");
        cliente1.setSenha("123");
        cliente1.addPerfil(Perfil.CLIENTE);

        Chamado chamado = Chamado.builder().observacoes("Primeiro Chamado").prioridade(Prioridade.MEDIA)
                .status(Status.ANDAMENTO).titulo("Chamado 1").cliente(cliente).tecnico(tecnico).build();
        Chamado chamado1 = Chamado.builder().tecnico(tecnico2).observacoes("Segundo Chamado").prioridade(Prioridade.ALTA)
                .status(Status.ABERTO).titulo("Chamado 2").cliente(cliente1).build();
        Chamado chamado2 = Chamado.builder().tecnico(tecnico3).observacoes("Terceiro Chamado").prioridade(Prioridade.BAIXA)
                .status(Status.ENCERRADO).titulo("Chamado 3").cliente(cliente2).build();
        Chamado chamado3 = Chamado.builder().tecnico(tecnico4).observacoes("Quarto Chamado").prioridade(Prioridade.MEDIA)
                .status(Status.ABERTO).titulo("Chamado 4").cliente(cliente3).build();

        pessoaRepository.saveAll(Arrays.asList(tecnico, tecnico2, tecnico3, tecnico4, tecnico5, cliente, cliente1, cliente2, cliente3));
        chamadoRepository.saveAll(Arrays.asList(chamado, chamado1, chamado2, chamado3));
    }

}
