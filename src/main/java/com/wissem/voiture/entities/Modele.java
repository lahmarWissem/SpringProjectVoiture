package com.wissem.voiture.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Modele {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idMod;
	private String nomMod;
	private String descriptionMod;
	
	@JsonIgnore
	@OneToMany (mappedBy = "modele")
	private List<Voiture> voitures;

}


