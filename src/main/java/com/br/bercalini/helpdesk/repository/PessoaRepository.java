package com.br.bercalini.helpdesk.repository;

import com.br.bercalini.helpdesk.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
