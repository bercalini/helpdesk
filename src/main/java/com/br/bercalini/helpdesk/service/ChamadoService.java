package com.br.bercalini.helpdesk.service;

import com.br.bercalini.helpdesk.dto.ChamadoDTO;
import com.br.bercalini.helpdesk.enums.Prioridade;
import com.br.bercalini.helpdesk.enums.Status;
import com.br.bercalini.helpdesk.model.Chamado;
import com.br.bercalini.helpdesk.model.Cliente;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.br.bercalini.helpdesk.repository.ChamadoRepository;
import com.br.bercalini.helpdesk.repository.ClienteRepository;
import com.br.bercalini.helpdesk.repository.TecnicoRepository;
import com.br.bercalini.helpdesk.service.exeception.ObjetoNaoEncontrado;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;


    @Transactional
    public Chamado create(ChamadoDTO chamadoDTO) {
        Cliente cliente = clienteRepository.findById(chamadoDTO.getCliente()).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + chamadoDTO.getCliente()));
        Tecnico tecnico = tecnicoRepository.findById(chamadoDTO.getTecnico()).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + chamadoDTO.getTecnico()));

        Chamado chamado = new Chamado();
        chamado.setTitulo(chamadoDTO.getTitulo());
        chamado.setPrioridade(Prioridade.toEnum(chamadoDTO.getPrioridade()));
        chamado.setStatus(Status.toEnum(chamadoDTO.getStatus()));
        chamado.setObservacoes(chamadoDTO.getObservacoes());
        chamado.setCliente(cliente);
        chamado.setTecnico(tecnico);
        return chamadoRepository.save(chamado);
    }

    @Transactional
    public Chamado update(Long id, ChamadoDTO chamadoDTO) {
        Chamado chamado = findById(id);
        BeanUtils.copyProperties(chamadoDTO, chamado, "id", "dataAbertura", "dataFechamento");
        return chamado;
    }

    public Chamado findById(Long id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontrado("Chamando com o id : " + id + " não encontrado"));
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }


}
