package com.example.QCM.service;

import com.example.QCM.entity.Etudiant;

import java.util.Optional;

public interface EtudiantService {

	 Etudiant registerEtudiant(Etudiant etudiant);

	    Optional<Etudiant> login(String email, String password);

   
}
