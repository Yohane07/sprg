package com.myoh.javaspring.controller;

import com.myoh.javaspring.entities.Utilisateur;
import com.myoh.javaspring.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("utilisateur")
public class UtilisateurController {
    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creerUnUtilisateur(@RequestBody Utilisateur utilisateur){
        this.utilisateurService.creerUnUtilisateur(utilisateur);

    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public  List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.recupererTousLesUtilisateurs();
    }
}
