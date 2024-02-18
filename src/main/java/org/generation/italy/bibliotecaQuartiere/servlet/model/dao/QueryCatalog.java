package org.generation.italy.bibliotecaQuartiere.servlet.model.dao;

public class QueryCatalog {

	public static final String loadAllLibri =
			" SELECT * "
		  + "   FROM libro";
	
	public static final String loadPrenotazioni =
			" SELECT * "
		  + "   FROM assegnazione "
		  + "  WHERE cittadino_numero_tessera = ? ";
	
	public static final String loadCittadino =
			" SELECT * "
		  + "   FROM cittadino "
		  + "  WHERE numero_tessera = ? ";
	
	
	public static final String addAssegnazione =
			" INSERT INTO assegnazione (cittadino_numero_tessera, libro_codice_libro, data_prenotazione) "
		  + "      VALUES (?,?, CURDATE()) ";
	
	public static final String loadLibriLiberi =
			" SELECT * "
		  + "   FROM libro "
		  + "  WHERE stato = LI ";
	
	public static final String loadLibriByPrimaryKey =
			" SELECT * "
		  + "   FROM libro "
		  + "  WHERE codice_libro = ? ";
	
	public static final String UpdateStato =
			 " UPDATE libro "
			+"    SET  stato = ? "
			+"  WHERE codice_libro = ? ";
			

}
