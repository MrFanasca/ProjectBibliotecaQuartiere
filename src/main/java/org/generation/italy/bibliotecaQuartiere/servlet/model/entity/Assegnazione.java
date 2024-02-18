package org.generation.italy.bibliotecaQuartiere.servlet.model.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Assegnazione {

	private int idAssegnazione;
	private int numeroTessera;
	private LocalDate dataPrenotazione;
	private LocalDate dataConsegna;
	private LocalDate dataRestituzione;
	private String codiceLibro;
	
	public Assegnazione(int idAssegnazione, int numeroTessera, LocalDate dataPrenotazione, String codiceLibro,
			LocalDate dataConsegna, LocalDate dataRestituzione) {
		super();
		this.idAssegnazione = idAssegnazione;
		this.numeroTessera = numeroTessera;
		this.dataPrenotazione = dataPrenotazione;
		this.codiceLibro = codiceLibro;
		this.dataConsegna = dataConsegna;
		this.dataRestituzione = dataRestituzione;
	}
	public Assegnazione( int numeroTessera) {
		super();
		this.numeroTessera = numeroTessera;
	}
	
	public Assegnazione( int numeroTessera, String codiceLibro, int idAssegnazione) {
		super();
		
		this.numeroTessera = numeroTessera;
		this.codiceLibro = codiceLibro;
		this.idAssegnazione = idAssegnazione;
	}
	
	public Assegnazione( int numeroTessera, String codiceLibro) {
		super();
		
		this.numeroTessera = numeroTessera;
		this.codiceLibro = codiceLibro;
	}
	
	public Assegnazione( String codiceLibro) {
		super();
		
		this.codiceLibro = codiceLibro;
	}
	
	public int getIdAssegnazione() {
		return idAssegnazione;
	}

	public void setIdAssegnazione(int idAssegnazione) {
		this.idAssegnazione = idAssegnazione;
	}

	public LocalDate getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(LocalDate dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public LocalDate getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(LocalDate dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}


	public int getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(int numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public LocalDate getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(LocalDate dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	
	public String getCodiceLibro() {
		return codiceLibro;
	}

	public void setCodiceLibro(String codiceLibro) {
		this.codiceLibro = codiceLibro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceLibro, dataConsegna, dataPrenotazione, dataRestituzione, idAssegnazione,
				numeroTessera);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assegnazione other = (Assegnazione) obj;
		return Objects.equals(codiceLibro, other.codiceLibro) && Objects.equals(dataConsegna, other.dataConsegna)
				&& Objects.equals(dataPrenotazione, other.dataPrenotazione)
				&& Objects.equals(dataRestituzione, other.dataRestituzione) && idAssegnazione == other.idAssegnazione
				&& numeroTessera == other.numeroTessera;
	}

	@Override
	public String toString() {
		return "Assegnazione [idAssegnazione=" + idAssegnazione + ", numeroTessera=" + numeroTessera
				+ ", dataPrenotazione=" + dataPrenotazione + ", codiceLibro=" + codiceLibro + ", dataConsegna="
				+ dataConsegna + ", dataRestituzione=" + dataRestituzione + "]";
	}


	
}
