package com.wissem.voiture.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wissem.voiture.entities.Voiture;
import com.wissem.voiture.repos.VoitureRepository;
import com.wissem.voiture.services.VoitureService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoitureRESTController {
	@Autowired
	VoitureService voitureService;
	@Autowired
	VoitureRepository voitrep;
	private int currentPosition = 5;
	
	 @RequestMapping(method = RequestMethod.GET)
	  public Page<Voiture>getAllVoitures(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,
	            @RequestParam(defaultValue = "nomVoiture") String order,
	            @RequestParam(defaultValue = "true") boolean asc	
			) {
		Page<Voiture> voitures = voitureService.findByOrderByPositionAsc(
                PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
        	voitures = voitureService.findByOrderByPositionAsc(
                    PageRequest.of(page, size, Sort.by(order).descending()));
		return voitures;
	}
	
	   @RequestMapping(path="all",method = RequestMethod.GET)
		public List<Voiture> getallvoitures() {
		return voitureService.findByOrderByPositionAsc();
		}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Voiture getVoitureById(@PathVariable("id") Long id) {
	return voitureService.getVoiture(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Voiture createVoiture(@RequestBody Voiture voiture) {
		  int lastPosition = voitrep.getLastPosition();
	      voiture.setPosition(lastPosition + 1);
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
	
	@RequestMapping(value="/byType/{type}",method = RequestMethod.GET)
	public List<Voiture> findByType(@PathVariable("type") String type) {
	return voitureService.findByType(type);
	}

}
