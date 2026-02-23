package com.myoh.javaspring.service;

import com.myoh.javaspring.entities.Avis;
import com.myoh.javaspring.entities.Utilisateur;
import com.myoh.javaspring.repositories.AvisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.myoh.javaspring.enums.TypeAvis.NEGATIF;
import static com.myoh.javaspring.enums.TypeAvis.POSITIF;

@Service
public class AvisService {
    private UtilisateurService utilisateurService;
    private AvisRepository avisRepository;

    public AvisService(UtilisateurService utilisateurService, AvisRepository avisRepository) {
        this.utilisateurService = utilisateurService;
        this.avisRepository = avisRepository;
    }


    public List<Avis> recupererLesAvis(String typeAvis){
        List<Avis> avisDansLaBdd = this.avisRepository.findAvisByType(typeAvis);
        if (typeAvis != null){
            return avisDansLaBdd;
        }else {
            System.out.println("Aucun avis du type: " + typeAvis + " n'a été trouvé");
            return this.avisRepository.findAll();
        }
    }
    public void creerUnAvis(Avis avis){
        Utilisateur utilisateur = this.utilisateurService.recupererOuCreerUnUtilisateur(avis.getUtilisateur());
        if(avis.getDescription().contains("pas")){
            avis.setType(NEGATIF);
        }else{
            avis.setType(POSITIF);
        }
        avis.setUtilisateur(utilisateur);
        this.avisRepository.save(avis);
    }

    public Avis recupererUnAvis(Integer id){
        Optional<Avis> avisOptional = this.avisRepository.findById(id);
        return avisOptional.orElse(null);
    }

    /*

    public void modifierUnAvis(Avis avis, Integer id) {
        Optional<Avis> avisDansLabdd = recupererUnAvis(id);
    }
    */
}
