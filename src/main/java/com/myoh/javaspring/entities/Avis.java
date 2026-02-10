package com.myoh.javaspring.entities;

import com.myoh.javaspring.enums.TypeAvis;
import jakarta.persistence.*;
import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "AVIS")
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    String description;
    @Column
    TypeAvis type;

    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "UTILISATEUR_ID")
    Utilisateur utilisateur;

    public Avis() {
    }

    public Avis(Integer id, String description, TypeAvis type, Utilisateur utilisateur) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.utilisateur = utilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeAvis getType() {
        return type;
    }

    public void setType(TypeAvis type) {
        this.type = type;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
