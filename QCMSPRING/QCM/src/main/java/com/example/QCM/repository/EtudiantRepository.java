package com.example.QCM.repository;


import com.example.QCM.entity.Etudiant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	Optional<Etudiant> findByEmail(String email);
}

