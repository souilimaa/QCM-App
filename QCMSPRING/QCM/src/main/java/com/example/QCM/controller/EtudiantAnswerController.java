package com.example.QCM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QCM.entity.EtudiantAnswer;
import com.example.QCM.service.EtudiantAnswerService;
@RestController
@RequestMapping("/Qcm/InsertEtudiantAnswer")
public class EtudiantAnswerController {
	
    @Autowired
    private EtudiantAnswerService etudiantAnswerService;
	@PostMapping("/save")
    public ResponseEntity<EtudiantAnswer> saveEtudiantAnswer(@RequestBody EtudiantAnswer etudiantAnswer) {
        EtudiantAnswer savedEtudiantAnswer = etudiantAnswerService.saveEtudiantAnswer(etudiantAnswer);
        return ResponseEntity.ok(savedEtudiantAnswer);
    }
}
