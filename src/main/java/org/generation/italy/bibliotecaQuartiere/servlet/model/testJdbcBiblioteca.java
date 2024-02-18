package org.generation.italy.bibliotecaQuartiere.servlet.model;

import java.sql.Connection;
import java.util.List;

import org.generation.italy.bibliotecaQuartiere.servlet.model.dao.AssegnazioneDao;
import org.generation.italy.bibliotecaQuartiere.servlet.model.dao.CittadinoDao;
import org.generation.italy.bibliotecaQuartiere.servlet.model.dao.LibroDao;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Assegnazione;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Libro;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
@Component
public class testJdbcBiblioteca {

	Connection dbConnection;
	
	public AssegnazioneDao getAssegnazioneDao() {
		return assegnazioneDao;
	}

	private LibroDao libroDao;
	private CittadinoDao cittadinoDao;
	private AssegnazioneDao assegnazioneDao;
	
	

	public testJdbcBiblioteca() throws ServletException {

		this.dbConnection = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost",
				"3306", "biblioteca_quartiere", "root", "").getDbConnection(); 
	this.libroDao = new LibroDao(this.dbConnection);	
	this.cittadinoDao = new CittadinoDao(this.dbConnection);
	this.assegnazioneDao = new AssegnazioneDao(this.dbConnection);
	
	}
	
	
	// ************************************************************************************************************************************+

	
	public AssegnazioneDao getPrenotazioneDao() {
		return assegnazioneDao;
	}

	
	// ************************************************************************************************************************************+

	public LibroDao getLibroDao() {
		return libroDao;
	}

	
// ************************************************************************************************************************************+

	
	public CittadinoDao getCittadinoDao() {
		return cittadinoDao;
	}

// ************************************************************************************************************************************+

	
public static void main(String[] args) {
	
//	try {
//		
//		testJdbcBiblioteca test = new testJdbcBiblioteca();
//		List<Libro> elencoLibri = test.libroDao.loadAllLibro();
//		System.out.println(elencoLibri.toString());
//					
//		Libro libro = null;
//		
//		Assegnazione assegnazione = null;
//		assegnazione = new Assegnazione( 1, libro.getCodiceLibro());
//		test.assegnazioneDao.addAssegnazione(assegnazione); 
//	
//		
//	} catch (ServletException bibliotecaModelException) {
//		System.out.println(bibliotecaModelException.getMessage());
//	}
//	
 }

//************************************************************************************************************************************+	
	
}
