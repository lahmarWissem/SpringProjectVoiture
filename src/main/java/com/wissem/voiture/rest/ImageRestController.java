package com.wissem.voiture.rest;
import com.wissem.voiture.entities.Image;
import com.wissem.voiture.entities.Voiture;
import com.wissem.voiture.services.ImageService;
import com.wissem.voiture.services.VoitureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {

    @Autowired
    ImageService imageService ;
    
    @Autowired
    VoitureService voitureService;
    
    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
    @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id) ;
    }
    @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        return imageService.getImage(id) ;
    }
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id){
        imageService.deleteImage(id);
    }
    @RequestMapping(value = "/loadimagevoit/{id}" , method = RequestMethod.GET)
    public Image getImageByName(@PathVariable("id") Long id) throws IOException {
    	Voiture voit=voitureService.findVoitureByIdVoiture(id);
        return imageService.getImageDetails(voit.getImage().getIdImage());
    }
    
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
}
