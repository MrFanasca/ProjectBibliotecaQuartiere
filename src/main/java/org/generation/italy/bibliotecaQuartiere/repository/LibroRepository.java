package org.generation.italy.bibliotecaQuartiere.repository;

import org.generation.italy.bibliotecaQuartiere.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String>{

	
}
