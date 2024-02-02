package com.example.QCM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QCM.entity.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    // Custom query methods if needed
}
