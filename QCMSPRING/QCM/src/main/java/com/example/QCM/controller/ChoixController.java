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

import com.example.QCM.DTO.ChoiceRequestDto;
import com.example.QCM.entity.Choix;
import com.example.QCM.service.ChoixService;

@RestController
@RequestMapping("/Qcm/choix")
public class ChoixController {

    @Autowired
    private ChoixService choixService;
    
    @GetMapping("/getByQuestionId/{questionId}")
    public ResponseEntity<List<Choix>> getChoixByQuestionId(@PathVariable Long questionId) {
        List<Choix> choixList = choixService.getChoixByQuestionId(questionId);
        if (choixList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(choixList);
    }

    
    @PostMapping("/add")
    public ResponseEntity<Choix> addChoice(@RequestBody ChoiceRequestDto choiceRequest) {
        Choix newChoice = choixService.addChoice(
                choiceRequest.getQuestionId(),
                choiceRequest.getChoixEnonce(),
                choiceRequest.isCorrect()
        );

        return new ResponseEntity<>(newChoice, HttpStatus.CREATED);
    }
}
