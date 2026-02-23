package com.myoh.javaspring.controller;

import com.myoh.javaspring.entities.Avis;
import com.myoh.javaspring.service.AvisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("avis")
public class AvisController {

    AvisService avisService;

    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creerUnAvis(@RequestBody Avis avis){
        this.avisService.creerUnAvis(avis);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE )
    public List<Avis> getAllavis(@RequestParam(required = false) String typeAvis){
        return this.avisService.recupererLesAvis(typeAvis);
    }

    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Avis getUnAvis(@PathVariable Integer id){
        return this.avisService.recupererUnAvis(id);
    }

    /*
    @PutMapping(path = "{id}")
    public void modifierUnAvis(Avis avis, @PathVariable Integer id){
        this.avisService.modifierUnAvis(avis, id);
    }
    */

}
