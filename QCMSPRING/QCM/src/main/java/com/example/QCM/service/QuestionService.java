package com.example.QCM.service;

import java.util.List;

import com.example.QCM.entity.Question;

public interface QuestionService {
    Question addQuestion(Question question);
	List<Question> getQuestionsByQCMId(Long qcmId);
	
}

