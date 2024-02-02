package com.example.QCM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QCM.DTO.QuestionRequest;
import com.example.QCM.entity.QCM;
import com.example.QCM.entity.Question;
import com.example.QCM.repository.QuestionRepository;
import com.example.QCM.service.QCMService;
import com.example.QCM.service.QuestionService;

@RestController
@RequestMapping("/Qcm/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired

    private QCMService qcmService; 

    @Autowired
    private QuestionRepository questionRepository;
 
    @GetMapping("/getQuestions/{qcmId}")
    public ResponseEntity<List<Question>> getQuestionsByQcmId(@PathVariable Long qcmId) {
        List<Question> questions = questionService.getQuestionsByQCMId(qcmId);
        if (questions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/add")
    public Question createQuestion(Long idQcm, String ennonce) {
        QCM qcm = qcmService.getQCMById(idQcm);
        Question question = new Question();
        question.setQcm(qcm);
        question.setEnnonce(ennonce);
        return questionRepository.save(question);
    }
}
