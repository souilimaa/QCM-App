package com.example.QCM.service;

import java.util.List;
import java.util.Optional;

import com.example.QCM.entity.Matiere;

public interface MatiereService {
    List<Matiere> getAllMatieres();
    Matiere createMatiere(Matiere matiere);
	Matiere findById(Long matiereId);
	Optional<Matiere> getMatiere(Long id);
}
