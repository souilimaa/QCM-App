package com.example.QCM.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QCM.entity.Matiere;
import com.example.QCM.service.MatiereService;

@RestController
@RequestMapping("/Qcm/matieres")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;
    
    @Autowired
    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Matiere>> getAllMatieres() {
        List<Matiere> matieres = matiereService.getAllMatieres();

        if (matieres.isEmpty()) {
            return ResponseEntity.<List<Matiere>>noContent().build();
        } else {
            return ResponseEntity.ok(matieres);
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity<Matiere> createMatiere(@RequestBody Matiere matiere) {
        Matiere createdMatiere = matiereService.createMatiere(matiere);

        if (createdMatiere != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMatiere);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    

}
