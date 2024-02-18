package org.generation.italy.bibliotecaQuartiere.repository;

import org.generation.italy.bibliotecaQuartiere.BibliotecaException;
import org.generation.italy.bibliotecaQuartiere.model.Libro;

public class Trigger {

	public static void checkBeforeCambioStato (Libro libro, String statoFuturo) throws BibliotecaException{
		
		if (statoFuturo.equals("TC") & !libro.getStato().equals("PR")) {
			throw new BibliotecaException("Trigger -> checkBeforeCambioStato -> un libro prima di essere consegnato deve essere prenotato"); 
		}
		else if (statoFuturo.equals("LI") & !libro.getStato().equals("TC")) {
			throw new BibliotecaException("Trigger -> checkBeforeCambioStato -> un libro prima di essere restituito deve essere consegnato"); 
		}
	}
	
}
