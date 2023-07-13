package com.br.bercalini.helpdesk.service;

import com.br.bercalini.helpdesk.dto.TecnicoDTO;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.br.bercalini.helpdesk.repository.TecnicoRepository;
import com.br.bercalini.helpdesk.service.exeception.ObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;


    public TecnicoDTO findById(Long id) {
        Tecnico tecnico = tecnicoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + id));
        return new TecnicoDTO(tecnico);
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }
}
