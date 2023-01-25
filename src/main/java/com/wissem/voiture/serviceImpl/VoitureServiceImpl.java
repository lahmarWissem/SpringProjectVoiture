package com.wissem.voiture.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import  com.wissem.voiture.repos.VoitureRepository;
import com.pusher.rest.Pusher;
import com.wissem.voiture.entities.Modele;
import com.wissem.voiture.entities.Voiture;
import com.wissem.voiture.services.*;

@Service
public class VoitureServiceImpl implements VoitureService {
	
	@Autowired
     VoitureRepository    voitureRepository;

	@Override
	public Voiture saveVoiture(Voiture v) {
		Voiture v1= voitureRepository.save(v);
		Pusher pusher = new Pusher("1522908", "f2100129475af588ae6e", "80fcde83ec934f9b6d72");
		pusher.setCluster("eu");

		pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", "Hello World"));
		return v1;
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
	public Voiture findVoitureByIdVoiture(Long id) {	
		return voitureRepository.findByIdVoiture(id);
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
	public Page<Voiture> findByOrderByPositionAsc(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return voitureRepository.findByOrderByPositionAsc( pageRequest);
	}

	@Override
	public List<Voiture> trierVoituresNomsPrix() {
		// TODO Auto-generated method stub
		return voitureRepository.TrierVoituresNomsPrix();
	}


	@Override
	public List<Voiture> findByOrderByPositionAsc() {
		// TODO Auto-generated method stub
		return voitureRepository.findByOrderByPositionAsc();
	}


	@Override
	public List<Voiture> findByType(String type) {
		// TODO Auto-generated method stub
		return voitureRepository.findByTypeOrderByPositionAsc(type);
	}



}
