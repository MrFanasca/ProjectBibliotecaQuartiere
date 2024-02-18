package org.generation.italy.bibliotecaQuartiere.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="assegnazione")
public class Assegnazione {
	
	/*************/
	// ATTRIBUTI //
	/************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_assegnazione", columnDefinition = "mediumint(9)")
	private Integer idAssegnazione;
	
	@Column(name="data_consegna", columnDefinition = "date")
	private LocalDate dataConsegna;
	
	@Column(name="data_restituzione", columnDefinition = "date")
	private LocalDate dataRestituzione;
	
	@Column(name="data_prenotazione", columnDefinition = "date")
	private LocalDate dataPrenotazione;
	
	@ManyToOne
	@JoinColumn(nullable = false, columnDefinition = "char(7)", name = "libro_codice_libro")
	private Libro libro;
	
	@ManyToOne
	@JoinColumn(nullable = false, columnDefinition = "mediumint(9)", name = "cittadino_numero_tessera")
	private Cittadino cittadino;

	/***************/
	// COSTRUTTORI //
	/**************/
	public Assegnazione() {
		super();
	}

	public Assegnazione(Integer idAssegnazione, /*Integer numero_tessera*/LocalDate dataConsegna, LocalDate dataRestituzione,
			Libro libro, Cittadino cittadino) {
		super();
		this.idAssegnazione = idAssegnazione;
//		this.numeroTessera = numeroTessera;
		this.dataConsegna = dataConsegna;
		this.dataRestituzione = dataRestituzione;
		this.libro = libro;
		this.cittadino = cittadino;
	}

	/*******************/
	// GETTER E SETTER //
	/******************/
	public int getIdAssegnazione() {
		return idAssegnazione;
	}

	public void setIdAssegnazione(int idAssegnazione) {
		this.idAssegnazione = idAssegnazione;
	}

//	public int getNumeroTessera() {
//		return numeroTessera;
//	}
//
//	public void setNumeroTessera(int numeroTessera) {
//		this.numeroTessera = numeroTessera;
//	}

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

	public Libro getLibro() {
		return libro;
	}

	public Cittadino getCittadino() {
		return cittadino;
	}

}
