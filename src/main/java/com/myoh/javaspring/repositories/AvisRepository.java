package com.myoh.javaspring.repositories;

import com.myoh.javaspring.entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
    List<Avis> findAvisByType(String typeavis);
}
