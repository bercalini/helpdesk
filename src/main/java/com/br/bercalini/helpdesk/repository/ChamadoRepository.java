package com.br.bercalini.helpdesk.repository;

import com.br.bercalini.helpdesk.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
}
