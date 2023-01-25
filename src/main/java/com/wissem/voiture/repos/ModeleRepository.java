package com.wissem.voiture.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wissem.voiture.entities.*;

@RepositoryRestResource(path = "mod")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface ModeleRepository extends JpaRepository<Modele, Long> {

}
