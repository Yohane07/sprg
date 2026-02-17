package com.myoh.javaspring.service;
import com.myoh.javaspring.entities.Utilisateur;
import com.myoh.javaspring.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private UtilisateurRepository utlisateurRepository;

    public UtilisateurService(UtilisateurRepository utlisateurRepository) {
        this.utlisateurRepository = utlisateurRepository;
    }
    public void creerUnUtilisateur(Utilisateur utilisateur){
        Utilisateur utilisateurExistant = this.utlisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurExistant == null){
            this.utlisateurRepository.save(utilisateur);
        }else {
            //TODO: Récupérer l'adresse mail et le renvoyer dans le retour
            System.out.print("Il y a déjà un utilisateur enregistré avec cette addresse mail");
        }
    }

    public List<Utilisateur> recupererTousLesUtilisateurs() {
        return this.utlisateurRepository.findAll();
    }

    public Utilisateur recupererUnUtilisateur(Integer id) {
        Optional <Utilisateur> utilisateurPossible = this.utlisateurRepository.findById(id);
        return utilisateurPossible.orElse(null);
    }

    public Utilisateur recupererOuCreerUnUtilisateur(Utilisateur utilisateurACreer) {
        Utilisateur utilisateurDansLaBDD = this.utlisateurRepository.findByEmail(utilisateurACreer.getEmail());
        if (utilisateurDansLaBDD == null){
            utilisateurDansLaBDD = this.utlisateurRepository.save(utilisateurACreer);
        }
        return utilisateurDansLaBDD;
    }

    public void supprimerUnUtilisateur(Integer idUtilisateurASupprimer){
        Optional<Utilisateur> utilisateurASupprimer = this.utlisateurRepository.findById(idUtilisateurASupprimer);
        if (utilisateurASupprimer.isPresent()){
            this.utlisateurRepository.deleteById(idUtilisateurASupprimer);
            System.out.print("L'utilisateur" + idUtilisateurASupprimer + "a bien été supprimé");
        }
        System.out.print("L'utilisateur" + idUtilisateurASupprimer + "n'existe pas");

    }

    public void modifierUnUtilisateur(Integer id, Utilisateur utilisateur) {
        Utilisateur utlisateurRechercheDansLaBdd = this.recupererUnUtilisateur(id);
        if(utlisateurRechercheDansLaBdd.getId() == utilisateur.getId()){
            utlisateurRechercheDansLaBdd.setEmail(utilisateur.getEmail());
            utlisateurRechercheDansLaBdd.setTelephone(utilisateur.getTelephone());
            utlisateurRepository.save(utlisateurRechercheDansLaBdd);

        }
    }
}
