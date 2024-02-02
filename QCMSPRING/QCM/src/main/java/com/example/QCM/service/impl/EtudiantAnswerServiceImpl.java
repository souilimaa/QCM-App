package com.example.QCM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.QCM.entity.EtudiantAnswer;
import com.example.QCM.repository.EtudiantAnswerRepository;
import com.example.QCM.service.EtudiantAnswerService;

@Service
public class EtudiantAnswerServiceImpl implements EtudiantAnswerService {

    @Autowired
    private EtudiantAnswerRepository etudiantAnswerRepository;

    @Override
    public EtudiantAnswer saveEtudiantAnswer(EtudiantAnswer etudiantAnswer) {
        return etudiantAnswerRepository.save(etudiantAnswer);
    }


}
