package com.myoh.javaspring.repositories;

import com.myoh.javaspring.entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
}
