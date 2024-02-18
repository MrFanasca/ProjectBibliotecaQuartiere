package org.generation.italy.bibliotecaQuartiere.repository;

import org.generation.italy.bibliotecaQuartiere.model.Volontario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolontarioRepository extends JpaRepository<Volontario, Integer>{

}
