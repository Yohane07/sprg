package com.myoh.javaspring.repositories;

import com.myoh.javaspring.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByEmail(String email);
}
