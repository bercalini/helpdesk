package com.br.bercalini.helpdesk.service;

import com.br.bercalini.helpdesk.converter.TecnicoConverter;
import com.br.bercalini.helpdesk.dto.TecnicoDTO;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.br.bercalini.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private TecnicoConverter tecnicoConverter;

    public TecnicoDTO findById(Long id) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        TecnicoDTO tecnicoDTO = tecnicoConverter.converterTecnicoTOConverterDTO(tecnico.get());
        return tecnicoDTO;
    }
}
