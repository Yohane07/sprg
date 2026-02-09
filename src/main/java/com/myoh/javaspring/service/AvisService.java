package com.myoh.javaspring.service;

import com.myoh.javaspring.entities.Avis;
import com.myoh.javaspring.repositories.AvisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvisService {

    AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    public List<Avis> recupererLesAvis(){
        return this.avisRepository.findAll();
    }
    public void creerUnAvis(Avis avis){
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
