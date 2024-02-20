package org.generation.italy.bibliotecaQuartiere.security.model;

import java.util.Set;

import org.generation.italy.bibliotecaQuartiere.model.Cittadino;
import org.generation.italy.bibliotecaQuartiere.model.Volontario;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;


@Entity
public class Utente {
	//campi obbligatori per la security
	@Id
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@OneToOne(mappedBy = "utente")		
	private Cittadino cittadino;
	
	@OneToOne(mappedBy = "utente")		
	private Volontario volontario;
	
	@ManyToMany(fetch = FetchType.EAGER)		//i ruoli vengono caricati contestualmente al caricamento dell'utente
	private Set<Ruolo> ruoli;					//ogni utente può assumere più ruoli

	public Utente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public Cittadino getCittadino() {
		return cittadino;
	}

	public Volontario getVolontario() {
		return volontario;
	}
	
	
}
