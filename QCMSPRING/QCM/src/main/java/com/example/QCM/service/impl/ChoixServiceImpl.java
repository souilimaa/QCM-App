package com.example.QCM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.QCM.entity.Choix;
import com.example.QCM.entity.Question;
import com.example.QCM.repository.ChoixRepository;
import com.example.QCM.repository.QuestionRepository;
import com.example.QCM.service.ChoixService;
import jakarta.persistence.EntityNotFoundException;

import java.awt.Choice;
import java.util.List;

@Service
public class ChoixServiceImpl implements ChoixService {

    @Autowired
    private ChoixRepository choixRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Choix> getChoixByQuestionId(long questionId) {
        return choixRepository.findByQuestionId(questionId);
    }

    @Override
    public List<Choix> getChoicesForQuestion(long questionId) {
        return choixRepository.findByQuestionId(questionId);
    }

    @Override
    public Choix addChoice(Long questionId, String choixEnonce, boolean isCorrect) {
        Question question = questionRepository.findById(questionId)
            .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        Choix choice = new Choix();
        choice.setQuestion(question);
        choice.setChoixEnonce(choixEnonce);
        choice.setCorrect(isCorrect);

        return choixRepository.save(choice);
    }
}
