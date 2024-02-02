package com.example.QCM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QCM.entity.Question;
import com.example.QCM.repository.QuestionRepository;
import com.example.QCM.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestionsByQCMId(Long qcmId) {
        return questionRepository.findByQcmId(qcmId);
    }
    
    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

}
