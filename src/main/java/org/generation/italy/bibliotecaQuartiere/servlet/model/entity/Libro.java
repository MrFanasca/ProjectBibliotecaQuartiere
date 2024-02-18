package org.generation.italy.bibliotecaQuartiere.servlet.model.entity;

import java.util.Objects;

public class Libro {

	private String codiceLibro;
	private String titolo;
	private String autore;
	private String editore;
	private String genere;
	private String stato;
	private String anno;
	private String descrizione;
	private int numeroPagine;
	
	
	public Libro(String codiceLibro, String titolo, String autore, String editore, String genere, String stato,
			String anno, String descrizione, int numeroPagine) {
		super();
		this.codiceLibro = codiceLibro;
		this.titolo = titolo;
		this.autore = autore;
		this.editore = editore;
		this.genere = genere;
		this.stato = stato;
		this.anno = anno;
		this.descrizione = descrizione;
		this.numeroPagine = numeroPagine;
	}
	
	public Libro(String codiceLibro, String titolo, String autore, String editore, String genere, String stato,
			String anno, String descrizione) {
		super();
		this.codiceLibro = codiceLibro;
		this.titolo = titolo;
		this.autore = autore;
		this.editore = editore;
		this.genere = genere;
		this.stato = stato;
		this.anno = anno;
		this.descrizione = descrizione;
	}
	
	public String getCodiceLibro() {
		return codiceLibro;
	}
	
	public Libro(String codiceLibro, String stato) {
		super();
		this.codiceLibro = codiceLibro;
		this.stato = stato;
		
	}
	
	public void setCodiceLibro(String codiceLibro) {
		this.codiceLibro = codiceLibro;
	}
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	public String getEditore() {
		return editore;
	}
	
	public void setEditore(String editore) {
		this.editore = editore;
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
	
	public int getNumeroPagine() {
		return numeroPagine;
	}
	
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(anno, autore, codiceLibro, descrizione, editore, genere, numeroPagine, stato, titolo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(anno, other.anno) && Objects.equals(autore, other.autore)
				&& codiceLibro == other.codiceLibro && Objects.equals(descrizione, other.descrizione)
				&& Objects.equals(editore, other.editore) && Objects.equals(genere, other.genere)
				&& numeroPagine == other.numeroPagine && Objects.equals(stato, other.stato)
				&& Objects.equals(titolo, other.titolo);
	}
	
	@Override
	public String toString() {
		return "Libro [codice libro=" + codiceLibro + "\n titolo=" + titolo + ", \n autore=" + autore
				+ ", \\neditore=" + editore + ",\\n genere=" + genere + ",\\n stato=" + stato + ", \\nanno=" + anno
				+ ", \\ndescrizione=" + descrizione + ", \\nnumeroPagine=" + numeroPagine + "]";
	}
	
	
	
}
