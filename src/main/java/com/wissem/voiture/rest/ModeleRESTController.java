package com.wissem.voiture.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wissem.voiture.entities.Modele;
import com.wissem.voiture.repos.*;

@RestController
@RequestMapping("/api/mod")
@CrossOrigin("*")
public class ModeleRESTController {
	@Autowired
	ModeleRepository modeleRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Modele> getAllModeles() {
		return modeleRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Modele getModeleById(@PathVariable("id") Long id) {
		return modeleRepository.findById(id).get();
	}
	
	
	
}