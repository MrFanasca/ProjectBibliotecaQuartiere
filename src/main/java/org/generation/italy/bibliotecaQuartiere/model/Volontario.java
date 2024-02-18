package org.generation.italy.bibliotecaQuartiere.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="volontario")
public class Volontario {

	/*************/
	// ATTRIBUTI //
	/************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codice_volontario", columnDefinition = "tinyint(4)")
	private Integer codiceVolontario;
	
	@Column(name="nominativo", columnDefinition = "varchar(35)")
	private String nominativo;
	
//	@JsonBackReference
//	@OneToMany(mappedBy = "volontario")
//	List<Assegnazione> elencoAssegnazioni;

	/***************/
	// COSTRUTTORI //
	/**************/
	public Volontario() {
		super();
	}
	
	public Volontario(int codiceVolontario, String nominativo) {
		super();
		this.codiceVolontario = codiceVolontario;
		this.nominativo = nominativo;
	}

	/*******************/
	// GETTER E SETTER //
	/******************/
	public int getCodiceVolontario() {
		return codiceVolontario;
	}

	public void setCodiceVolontario(int codiceVolontario) {
		this.codiceVolontario = codiceVolontario;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	/**********/
	// METODI //
	/**********/
	@Override
	public String toString() {
		return "Volontario [codiceVolontario=" + codiceVolontario + ", nominativo=" + nominativo + "]";
	}
	
}
