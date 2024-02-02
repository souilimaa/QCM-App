package com.example.QCM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.QCM.entity.QCM;
import com.example.QCM.service.QCMService;

@RestController
@RequestMapping("/Qcm/qcms")
public class QCMController {

    @Autowired
    private QCMService qcmService;

    @PostMapping("/create")
    public ResponseEntity<QCM> createQCM(@RequestBody QCM qcm) {
        try {
            QCM createdQCM = qcmService.createQCM(qcm);
            return ResponseEntity.ok(createdQCM);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getByMatiereId/{matiereId}")
    public ResponseEntity<List<QCM>> getQCMsByMatiereId(@PathVariable String matiereId) {
        try {
            Long parsedMatiereId = Long.parseLong(matiereId);
            List<QCM> qcms = qcmService.getQcmByMatiereId(parsedMatiereId);
            if (qcms.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(qcms);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
    @GetMapping("/getById/{qcmId}")
    public ResponseEntity<QCM> getQCMById(@PathVariable Long qcmId) {
        QCM qcm = qcmService.getQCMById(qcmId);
        if (qcm == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(qcm);
    }
}
