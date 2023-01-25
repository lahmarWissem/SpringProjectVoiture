package com.wissem.voiture.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.wissem.voiture.entities.Modele;
import com.wissem.voiture.entities.Voiture;

@RepositoryRestResource(path = "rest")
public interface VoitureRepository  extends JpaRepository<Voiture, Long> {
	List<Voiture> findByNomVoiture(String nom);
	  Voiture findByIdVoiture(Long id);
	 List<Voiture> findByNomVoitureContains(String nom); 
	 
	 //@Query("select p from Voiture p where p.nomVoiture like %?1 and p.prixVoiture > ?2")
	 //List<Voiture> findByNomPrix (String nom, Double prix);
	 
	 @Query("select p from Voiture p where p.nomVoiture like %:nom and p.prixVoiture > :prix")
	 List<Voiture> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 @Query("select p from Voiture p where p.modele = ?1")
	 List<Voiture> findByModele (Modele modele);

	 List<Voiture> findByModeleIdMod(Long id);
	 
	 Page<Voiture> findByOrderByPositionAsc(PageRequest pageRequest);
	 List<Voiture> findByOrderByPositionAsc();
	 List<Voiture> findByTypeOrderByPositionAsc(String type);
	 @Query("select p from Voiture p order by p.nomVoiture ASC, p.prixVoiture DESC")
	 List<Voiture> TrierVoituresNomsPrix ();
	 
     @Query("SELECT MAX(i.position) FROM Voiture i")
     int getLastPosition();
}
