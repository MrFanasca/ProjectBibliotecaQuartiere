package org.generation.italy.bibliotecaQuartiere.servlet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.generation.italy.bibliotecaQuartiere.servlet.model.BibliotecaModelException;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Cittadino;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class CittadinoDao extends ADao{
	
	public CittadinoDao(Connection jdbcConnectionToDatabase) {
		super(jdbcConnectionToDatabase);
		// TODO Auto-generated constructor stub
	}

	private List<Cittadino> loadCittadinoByQuery(PreparedStatement preparedStatement) throws BibliotecaModelException {

		List<Cittadino> listaCittadini = new ArrayList<>();
		try {
			ResultSet rsSelect = preparedStatement.executeQuery();

			while (rsSelect.next()) {

				int numeroTessera = rsSelect.getInt("numero_tessera");
				if (rsSelect.wasNull()) {
					numeroTessera = 0;
				}

				String nominativo = rsSelect.getString("nominativo");
				if (rsSelect.wasNull()) {
					nominativo = "";
				}

				String codiceFiscale = rsSelect.getString("codice_fiscale");
				if (rsSelect.wasNull()) {
					codiceFiscale = "";
				}
				
				String indirizzoResidenza = rsSelect.getString("indirizzo_residenza");
				if (rsSelect.wasNull()) {
					indirizzoResidenza = "";
				}

				Cittadino cittadino = new Cittadino(numeroTessera, codiceFiscale, nominativo, indirizzoResidenza);
				listaCittadini.add(cittadino);

			}
		} catch (SQLException e) {
			throw new BibliotecaModelException("Prenotazione Dao --> loadMetodoByPrenotazione" + e.getMessage());
		}

		return listaCittadini;
	}

	
	
	public List<Cittadino> mostraCittadino(Integer numeroTessera) throws BibliotecaModelException{
			
			List<Cittadino> listaCittadini = new ArrayList<>();
			
			try {
				
				PreparedStatement preparedStatement = this.jdbcConnectionToDatabase
						.prepareStatement(QueryCatalog.loadCittadino);
				preparedStatement.setInt(1, numeroTessera);
				
				listaCittadini=loadCittadinoByQuery(preparedStatement);
				
							
			} catch (SQLException sqlException) {
				throw new BibliotecaModelException("AssegnazioneDao --> mostraPrenotazioni" + sqlException.getMessage()) ;
			}
			
			return listaCittadini;
	}
}
