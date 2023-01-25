package com.wissem.voiture.entities;

import java.util.Date;

import javax.persistence.Column;
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
	private String type;
	
	private int position;

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



	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Image getImage() {
		return image;

	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", nomVoiture=" + nomVoiture + ", prixVoiture=" + prixVoiture
				+ ", dateCreation=" + dateCreation + ", type=" + type + ", position=" + position + ", modele=" + modele
				+ ", image=" + image + "]";
	}

	public Voiture(long idVoiture, String nomVoiture, Double prixVoiture, Date dateCreation, String type, int position,
			Modele modele, Image image) {
		super();
		this.idVoiture = idVoiture;
		this.nomVoiture = nomVoiture;
		this.prixVoiture = prixVoiture;
		this.dateCreation = dateCreation;
		this.type = type;
		this.position = position;
		this.modele = modele;
		this.image = image;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
