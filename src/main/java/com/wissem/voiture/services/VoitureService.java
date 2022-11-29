package com.wissem.voiture.services;

import java.util.List;

import com.wissem.voiture.entities.Modele;
import com.wissem.voiture.entities.Voiture;

public interface VoitureService {
	
	Voiture saveVoiture(Voiture v);

	Voiture updateVoiture(Voiture v);

	void deleteVoiture(Voiture v);

	void deleteVoitureById(Long id);

	Voiture getVoiture(Long id);

	List<Voiture> getAllVoitures();

	List<Voiture> findByNomVoiture(String nom);

	List<Voiture> findByNomVoitureContains(String nom);

	List<Voiture> findByNomPrix(String nom, Double prix);

	List<Voiture> findByModele(Modele modele);

	List<Voiture> findByModeleIdMod(Long id);

	List<Voiture> findByOrderByNomVoitureAsc();

	List<Voiture> trierVoituresNomsPrix();
	

}
