package org.generation.italy.bibliotecaQuartiere.security.repository;

import java.util.Optional;

import org.generation.italy.testspring.security.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer>{
	Optional<Utente> findByUsername(String username);

}
