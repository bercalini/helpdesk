package com.br.bercalini.helpdesk.repository;

import com.br.bercalini.helpdesk.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
