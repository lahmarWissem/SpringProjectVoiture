package com.wissem.voiture.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.wissem.voiture.repos.VoitureRepository;
import com.wissem.voiture.entities.Modele;
import com.wissem.voiture.entities.Voiture;
import com.wissem.voiture.services.*;

@Service
public class VoitureServiceImpl implements VoitureService {
	
	@Autowired
   VoitureRepository    voitureRepository;

	@Override
	public Voiture saveVoiture(Voiture v) {
		return voitureRepository.save(v);
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		// TODO Auto-generated method stub
	return voitureRepository.save(v);
	}

	@Override
	public void deleteVoiture(Voiture v) {
		 voitureRepository.delete(v);
		
	}

	@Override
	public void deleteVoitureById(Long id) {
		voitureRepository.deleteById(id);
		
	}

	@Override
	public Voiture getVoiture(Long id) {
       return voitureRepository.findById(id).get();
	}

	@Override
	public List<Voiture> getAllVoitures() {
		// TODO Auto-generated method stub
		return voitureRepository.findAll();
	}

	@Override
	public List<Voiture> findByNomVoiture(String nom) {
		// TODO Auto-generated method stub
		return voitureRepository.findByNomVoiture(nom);
	}

	@Override
	public List<Voiture> findByNomVoitureContains(String nom) {
		// TODO Auto-generated method stub
		return voitureRepository.findByNomVoitureContains(nom);
	}

	@Override
	public List<Voiture> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return voitureRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Voiture> findByModele(Modele modele) {
		// TODO Auto-generated method stub
		return voitureRepository.findByModele(modele);
	}

	@Override
	public List<Voiture> findByModeleIdMod(Long id) {
		// TODO Auto-generated method stub
		return voitureRepository.findByModeleIdMod(id);
	}

	@Override
	public List<Voiture> findByOrderByNomVoitureAsc() {
		// TODO Auto-generated method stub
		return voitureRepository.findByOrderByNomVoitureAsc();
	}

	@Override
	public List<Voiture> trierVoituresNomsPrix() {
		// TODO Auto-generated method stub
		return voitureRepository.TrierVoituresNomsPrix();
	}

}
