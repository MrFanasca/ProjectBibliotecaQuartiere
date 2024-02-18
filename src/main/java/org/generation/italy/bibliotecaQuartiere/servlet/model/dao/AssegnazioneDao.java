package org.generation.italy.bibliotecaQuartiere.servlet.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.generation.italy.bibliotecaQuartiere.servlet.model.BibliotecaModelException;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Assegnazione;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AssegnazioneDao extends ADao {

	public AssegnazioneDao(Connection jdbcConnectionToDatabase) {
		super(jdbcConnectionToDatabase);
		// TODO Auto-generated constructor stub
	}

//	@Autowired
//	private DatasourceProperties datasourceProperties;

//	protected Connection getConnection() {
//        Connection connection = null;
//
//        try {        
//            Class.forName(datasourceProperties.getDriver_class_name());
//            connection = DriverManager.getConnection(
//            		datasourceProperties.getUrl(), 
//            		datasourceProperties.getUsername(), 
//            		datasourceProperties.getPassword());
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }  
//        return connection;
//
//    }

	// ************************************************************************************************************************************+

	private List<Assegnazione> loadAssegnazioneByQuery(PreparedStatement preparedStatement)
			throws BibliotecaModelException {

		List<Assegnazione> listaPrenotazioni = new ArrayList<>();
		try {
			ResultSet rsSelect = preparedStatement.executeQuery();

			while (rsSelect.next()) {

				int idAssegnazione = rsSelect.getInt("id_assegnazione");
				if (rsSelect.wasNull()) {
					idAssegnazione = 0;
				}

				int numeroTessera = rsSelect.getInt("cittadino_numero_tessera");
				if (rsSelect.wasNull()) {
					numeroTessera = 0;
				}

				LocalDate dataPrenotazione = rsSelect.getDate("data_prenotazione").toLocalDate();
				if (rsSelect.wasNull()) {
					dataPrenotazione = LocalDate.of(1, 1, 1);
				}

				String codiceLibro = rsSelect.getString("libro_codice_libro");
				if (rsSelect.wasNull()) {
					codiceLibro = "";
				}

				LocalDate dataConsegna = LocalDate.ofEpochDay(0);
				if (rsSelect.getDate("data_consegna")!=null) {
					dataConsegna = rsSelect.getDate("data_consegna").toLocalDate();
				}

				LocalDate dataRestituzione = LocalDate.ofEpochDay(0);
				if (rsSelect.getDate("data_restituzione")!=null) {
					dataRestituzione = rsSelect.getDate("data_restituzione").toLocalDate();
				}

				Assegnazione assegnazione = new Assegnazione(idAssegnazione, numeroTessera, dataPrenotazione,
						codiceLibro, dataConsegna, dataRestituzione);
				listaPrenotazioni.add(assegnazione);

			}
		} catch (SQLException e) {
			throw new BibliotecaModelException("Prenotazione Dao --> loadMetodoByPrenotazione" + e.getMessage());
		}

		return listaPrenotazioni;
	}

// ************************************************************************************************************************************+

	public void addAssegnazione(Assegnazione assegnazione) throws BibliotecaModelException {

		try {
			Triggers.checkBeforeInsertAssegnazione(assegnazione.getCodiceLibro(), assegnazione.getNumeroTessera());
			PreparedStatement preparedStatement = this.jdbcConnectionToDatabase
					.prepareStatement(QueryCatalog.addAssegnazione);

			preparedStatement.setInt(1, assegnazione.getNumeroTessera());
			preparedStatement.setString(2, assegnazione.getCodiceLibro());

			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			throw new BibliotecaModelException("AssegnazioneDao --> addAssegnazione ->" + sqlException.getMessage());
		}

	}
	
	public List<Assegnazione> mostraPrenotazioni(Integer numeroTessera) throws BibliotecaModelException{
		
		List<Assegnazione> listaPrenotazioni = new ArrayList<>();
		
		try {
			
			PreparedStatement preparedStatement = this.jdbcConnectionToDatabase
					.prepareStatement(QueryCatalog.loadPrenotazioni);
			preparedStatement.setInt(1, numeroTessera);
			
			listaPrenotazioni=loadAssegnazioneByQuery(preparedStatement);
			
						
		} catch (SQLException sqlException) {
			throw new BibliotecaModelException("AssegnazioneDao --> mostraPrenotazioni" + sqlException.getMessage()) ;
		}
		
		return listaPrenotazioni;
	}

	// ************************************************************************************************************************************+

//	public void updateStatoTC(Assegnazione assegnazione) throws BibliotecaModelException {
//		
//		try {
//			PreparedStatement preparedStatement = this.jdbcConnectionToDatabase.prepareStatement(QueryCatalog.UpdateStato);
//			
//			
//			
//			preparedStatement.setString(1, prenotazione.getCodiceLibro());
//			
//			preparedStatement.executeUpdate();
//			
//		} catch (SQLException sqlException) {
//			throw new BibliotecaModelException("PrenotazioneDao --> updateStato ->" + sqlException.getMessage());
//		}
//		
		
//	}

}
