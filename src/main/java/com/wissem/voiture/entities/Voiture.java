package com.wissem.voiture.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voiture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVoiture;
	private String nomVoiture;
	private Double prixVoiture;
	private Date dateCreation;

	@ManyToOne
	private Modele modele;

	@ManyToOne
	private Image image;

	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(long idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getNomVoiture() {
		return nomVoiture;
	}

	public void setNomVoiture(String nomVoiture) {
		this.nomVoiture = nomVoiture;
	}

	public Double getPrixVoiture() {
		return prixVoiture;
	}

	public void setPrixVoiture(Double prixVoiture) {
		this.prixVoiture = prixVoiture;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voiture(String nomVoiture, Double prixVoiture, Date dateCreation) {
		super();
		this.nomVoiture = nomVoiture;
		this.prixVoiture = prixVoiture;
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", nomVoiture=" + nomVoiture + ", prixVoiture=" + prixVoiture + "]";
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Image getImage() {
		return image;

	}
}
