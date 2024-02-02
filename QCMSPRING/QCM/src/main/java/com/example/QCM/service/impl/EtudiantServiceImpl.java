package com.example.QCM.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QCM.entity.Etudiant;
import com.example.QCM.repository.EtudiantRepository;
import com.example.QCM.service.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant registerEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Optional<Etudiant> login(String email, String password) {
        return etudiantRepository.findByEmail(email)
                .filter(etudiant -> password.equals(etudiant.getPassword()));
    }

}
