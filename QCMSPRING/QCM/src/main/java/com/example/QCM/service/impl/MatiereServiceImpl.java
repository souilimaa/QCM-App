package com.example.QCM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QCM.entity.Matiere;
import com.example.QCM.repository.MatiereRepository;
import com.example.QCM.service.MatiereService;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereServiceImpl implements MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    @Override
    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public Matiere createMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }
    @Override
    public Matiere findById(Long matiereId) {
        return matiereRepository.findById(matiereId).orElse(null);
    }
    @Override
    public Optional<Matiere> getMatiere(Long id) {
        return matiereRepository.findById(id);
    }
}
