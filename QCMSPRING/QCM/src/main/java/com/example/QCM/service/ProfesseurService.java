package com.example.QCM.service;

import com.example.QCM.entity.Professeur;

import java.util.Optional;

public interface ProfesseurService {

 
    Optional<Professeur> login(String email, String password);

}
