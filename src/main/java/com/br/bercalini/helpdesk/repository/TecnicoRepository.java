package com.br.bercalini.helpdesk.repository;

import com.br.bercalini.helpdesk.dto.TecnicoDTO;
import com.br.bercalini.helpdesk.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

 //   @Query("FROM Tecnico AS t JOIN FETCH t.chamados AS c WHERE t.id = ?1")
    Optional<Tecnico> findById(Long id);
}
