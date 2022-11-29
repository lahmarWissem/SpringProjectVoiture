package com.wissem.voiture.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wissem.voiture.entities.Voiture;
import com.wissem.voiture.services.VoitureService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoitureRESTController {
	@Autowired
	VoitureService voitureService;

	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Voiture> getAllVoitures() {
		return voitureService.getAllVoitures();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Voiture getVoitureById(@PathVariable("id") Long id) {
	return voitureService.getVoiture(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Voiture createVoiture(@RequestBody Voiture voiture) {
	return voitureService.saveVoiture(voiture);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Voiture updateVoiture(@RequestBody Voiture voiture) {
	return voitureService.updateVoiture(voiture);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteVoiture(@PathVariable("id") Long id)
	{
	voitureService.deleteVoitureById(id);
	}
	
	@RequestMapping(value="/voitmod/{idMod}",method = RequestMethod.GET)
	public List<Voiture> getVoituresByModId(@PathVariable("idMod") Long idMod) {
	return voitureService.findByModeleIdMod(idMod);
	}
	
	//faire la recherche des voitures par le nom de categorie 
	@RequestMapping(value="/voitsByName/{nom}",method = RequestMethod.GET)
	public List<Voiture> findByNomVoitureContains(@PathVariable("nom") String nom) {
	return voitureService.findByNomVoitureContains(nom);
	}

}
