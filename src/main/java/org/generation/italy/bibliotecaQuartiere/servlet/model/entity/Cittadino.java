package org.generation.italy.bibliotecaQuartiere.servlet.model.entity;

import java.util.Objects;

public class Cittadino {

	private int numeroTessera;
	private String codiceFiscale;
	private String nominativo;
	private String indirizzoResidenza;
	
	public Cittadino(int numeroTessera, String codiceFiscale, String nominativo, String indirizzoResidenza) {
		super();
		this.numeroTessera = numeroTessera;
		this.codiceFiscale = codiceFiscale;
		this.nominativo = nominativo;
		this.indirizzoResidenza = indirizzoResidenza;
	}
	
	public Cittadino(int numeroTessera, String codiceFiscale, String nominativo) {
		super();
		this.numeroTessera = numeroTessera;
		this.codiceFiscale = codiceFiscale;
		this.nominativo = nominativo;
	}
	
	
	public Cittadino(int numeroTessera) {
		super();
		this.numeroTessera = numeroTessera;
		
	}
	
	public int getNumeroTessera() {
		return numeroTessera;
	}
	
	public void setNumeroTessera(int numeroTessera) {
		this.numeroTessera = numeroTessera;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getNominativo() {
		return nominativo;
	}
	
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}
	
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codiceFiscale, indirizzoResidenza, nominativo, numeroTessera);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cittadino other = (Cittadino) obj;
		return Objects.equals(codiceFiscale, other.codiceFiscale)
				&& Objects.equals(indirizzoResidenza, other.indirizzoResidenza)
				&& Objects.equals(nominativo, other.nominativo) && numeroTessera == other.numeroTessera;
	}
	
	
	@Override
	public String toString() {
		return "Cittadino [numeroTessera=" + numeroTessera + ", codiceFiscale=" + codiceFiscale + ", nominativo="
				+ nominativo + ", indirizzoResidenza=" + indirizzoResidenza + "]";
	}
	
	
	
	
	
}
