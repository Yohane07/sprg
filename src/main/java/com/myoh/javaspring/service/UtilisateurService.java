package com.myoh.javaspring.service;
import com.myoh.javaspring.entities.Utilisateur;
import com.myoh.javaspring.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private UtilisateurRepository utlisateurRepository;

    public UtilisateurService(UtilisateurRepository utlisateurRepository) {
        this.utlisateurRepository = utlisateurRepository;
    }
    public void creerUnUtilisateur(Utilisateur utilisateur){
        this.utlisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> recupererTousLesUtilisateurs() {
        return this.utlisateurRepository.findAll();
    }
}
