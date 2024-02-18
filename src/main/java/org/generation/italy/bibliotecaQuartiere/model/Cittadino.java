package org.generation.italy.bibliotecaQuartiere.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cittadino")
public class Cittadino {

	/*************/
	// ATTRIBUTI //
	/************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero_tessera", columnDefinition = "mediumint(9)")
	private int numeroTessera;
	
	@Column(name="nominativo", columnDefinition = "varchar(35)")
	private String nominativo;
	
	@Column(name="codice_fiscale", columnDefinition = "char(16)")
	private String codiceFiscale;
	
	@Column(name="indirizzo_residenza", columnDefinition = "varchar(50)")
	private String indirizzo;
	
	@JsonBackReference
	@OneToMany(mappedBy = "cittadino")
	List<Assegnazione> elencoAssegnazioni;

	/***************/
	// COSTRUTTORI //
	/**************/
	public Cittadino() {					// necessario????(Enzo)
		super();
	}

	public Cittadino(String nominativo, String codiceFiscale, String indirizzo) {
		super();
		this.nominativo = nominativo;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
	}

	/*******************/
	// GETTER E SETTER //
	/******************/
	public int getNumeroTessera() {
		return numeroTessera;
	}

	public String getNominativo() {
		return nominativo;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setNumeroTessera(int numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**********/
	// METODI //
	/**********/
	@Override
	public String toString() {
		return "Cittadino [numeroTessera=" + numeroTessera + ", nominativo=" + nominativo + ", codiceFiscale="
				+ codiceFiscale + ", indirizzo=" + indirizzo + "]";
	}
	
	
}
