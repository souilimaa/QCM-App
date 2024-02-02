package com.example.QCM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QCM.entity.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
    Optional<Professeur> findByEmail(String email);
}