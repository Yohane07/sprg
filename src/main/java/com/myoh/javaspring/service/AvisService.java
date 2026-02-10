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
        if (typeAvis == null){
            return this.avisRepository.findAll();
        }else {
            return this.avisRepository.findAvisByType(typeAvis);
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

    public Optional<Avis> recupererUnAvis(Integer id){
        Optional<Avis> avisOptional = this.avisRepository.findById(id);
        if(avisOptional.isPresent()){
            return avisOptional;
        }
        return null;
    }
}
