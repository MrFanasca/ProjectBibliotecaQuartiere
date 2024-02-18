package org.generation.italy.bibliotecaQuartiere.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {

	/*************/
	// ATTRIBUTI //
	/************/
	@Id
	@Column(name="codice_libro", columnDefinition = "char(7)")
	private String codiceLibro;
	
	@Column(name="titolo", nullable=false, columnDefinition = "varchar(35)")
	private String titolo;
	
	@Column(name="editore", nullable=false, columnDefinition = "varchar(20)")
	private String editore;
	
	@Column(name="autore", nullable=false, columnDefinition = "varchar(35)")
	private String autore;
	
	@Column(name="genere", nullable=false, columnDefinition = "varchar(20)")
	private String genere;
	
	@Column(name="stato", columnDefinition = "char(2)")
	private String stato="LI";
	
	@Column(name="anno_edizione", columnDefinition = "char(4)")
	private String anno;
	
	@Column(name="descrizione", columnDefinition = "varchar(400)")
	private String descrizione;
	
	@Column(name="nr_pagine", columnDefinition = "smallint unsigned")
	private int nrPagine;

	@JsonBackReference
	@OneToMany(mappedBy = "libro")
	List<Assegnazione> elencoAssegnazioni;
	
	/***************/
	// COSTRUTTORI //
	/**************/
	public Libro() {
		super();
	}

	public Libro(String codiceLibro, String titolo, String editore, String autore, String genere, String anno,
			String descrizione, int nrPagine) {
		super();
		this.codiceLibro = codiceLibro;
		this.titolo = titolo;
		this.editore = editore;
		this.autore = autore;
		this.genere = genere;
		this.stato = "LI";
		this.anno = anno;
		this.descrizione = descrizione;
		this.nrPagine = nrPagine;
	}

	/*******************/
	// GETTER E SETTER //
	/******************/
	public String getCodiceLibro() {
		return codiceLibro;
	}

	public void setCodiceLibro(String codiceBiblioteca) {
		this.codiceLibro = codiceBiblioteca;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getNrPagine() {
		return nrPagine;
	}

	public void setNrPagine(int nrPagine) {
		this.nrPagine = nrPagine;
	}

	/**********/
	// METODI //
	/**********/
	@Override
	public String toString() {
		return "Libro [codiceBiblioteca=" + codiceLibro + ", titolo=" + titolo + ", editore=" + editore
				+ ", autore=" + autore + ", genere=" + genere + ", stato=" + stato + ", anno=" + anno + ", descrizione="
				+ descrizione + ", nrPagine=" + nrPagine + "]";
	}
	
	
}
