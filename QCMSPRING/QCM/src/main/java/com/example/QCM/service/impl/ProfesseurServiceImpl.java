package com.example.QCM.service.impl;

import com.example.QCM.entity.Professeur;
import com.example.QCM.repository.ProfesseurRepository;
import com.example.QCM.service.ProfesseurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    private final ProfesseurRepository professeurRepository;

    @Autowired
    public ProfesseurServiceImpl(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    @Override
    public Optional<Professeur> login(String email, String password) {
        Optional<Professeur> professeur = professeurRepository.findByEmail(email);
        if (professeur.isPresent() && password.equals(professeur.get().getPassword())) {
            return professeur;
        }

        return Optional.empty();
    }

}