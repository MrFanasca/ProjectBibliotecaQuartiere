package org.generation.italy.bibliotecaQuartiere.servlet.model.dao;

import java.time.LocalDate;
import java.util.List;

import org.generation.italy.bibliotecaQuartiere.servlet.model.BibliotecaModelException;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Assegnazione;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Cittadino;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Libro;

public class Triggers {
	
	public static LibroDao libroDao;
	public static CittadinoDao cittadinoDao;
	public static AssegnazioneDao assegnazioneDao;
	
	public static void checkBeforeInsertAssegnazione (String codiceLibro, int numeroTessera) throws BibliotecaModelException {
		
		Libro libro = libroDao.loadLibroByPrimaryKey(codiceLibro);
		// 1)Controllo sullo stato libero del libro
		if (!libro.getStato().toUpperCase().equals("LI")) {
			throw new BibliotecaModelException ("Trigger -> checkBeforeInsertAssegnazione -> una prenotazione pu� essere effttuata solo se lo stato del libro � LI (Libero);");
		}
		
		// 2)Controllo sul numero massimo di prenotazioni effettuabili dal singolo cittadino
		List<Assegnazione> elencoAssegnazioni = assegnazioneDao.mostraPrenotazioni(numeroTessera);
		LocalDate unAnnoFa = LocalDate.now().minusYears(1);
		
		for (Assegnazione i:elencoAssegnazioni) {
			if (i.getDataPrenotazione().compareTo(unAnnoFa) < 0) {
				elencoAssegnazioni.remove(i);
			}
		}
		
		if (elencoAssegnazioni.size()>=6)
		{
			throw new BibliotecaModelException ("Trigger -> checkBeforeInsertAssegnazione -> possono essere effettuate un massimo di 6 prenotazioni all'anno");
		}
	}
	

}
