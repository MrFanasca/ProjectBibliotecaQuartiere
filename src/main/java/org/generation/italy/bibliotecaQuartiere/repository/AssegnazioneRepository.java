package org.generation.italy.bibliotecaQuartiere.repository;

import java.util.List;

import org.generation.italy.bibliotecaQuartiere.model.Assegnazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssegnazioneRepository extends JpaRepository<Assegnazione, Integer>{

    @Query( value = "  SELECT a.* "
    		+ "  FROM assegnazione a INNER JOIN libro l ON l.codice_libro=a.libro_codice_libro "
    		+ " WHERE l.stato!='LI'", nativeQuery = true)
    List<Assegnazione> findAssegnazione();
	
    @Query( value = "  SELECT a.* "
    		+ "  FROM assegnazione a INNER JOIN libro l ON l.codice_libro=a.libro_codice_libro "
    		+ " WHERE l.codice_libro = ? ", nativeQuery = true)
    List<Assegnazione> findByCodiceLibroLike(String codiceLibro);
}
