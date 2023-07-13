package com.br.bercalini.helpdesk.converter;

import com.br.bercalini.helpdesk.dto.TecnicoDTO;
import com.br.bercalini.helpdesk.model.Tecnico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TecnicoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public TecnicoDTO converterTecnicoTOConverterDTO(Tecnico tecnico) {
        return modelMapper.map(tecnico, TecnicoDTO.class);
    }

}
