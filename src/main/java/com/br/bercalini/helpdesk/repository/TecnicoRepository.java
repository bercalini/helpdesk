package com.br.bercalini.helpdesk.repository;

import com.br.bercalini.helpdesk.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}
