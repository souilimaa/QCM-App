package com.example.QCM.controller;


import com.example.QCM.entity.Etudiant;
import com.example.QCM.entity.Professeur;
import com.example.QCM.service.EtudiantService;
import com.example.QCM.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final EtudiantService etudiantService;
    private final ProfesseurService professeurService;

    @Autowired
    public AuthController(EtudiantService etudiantService, ProfesseurService professeurService) {
        this.etudiantService = etudiantService;
        this.professeurService = professeurService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.registerEtudiant(etudiant);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Etudiant registered successfully");

        return ResponseEntity.ok(response);
    }


    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Optional<Etudiant> etudiant = etudiantService.login(email, password);
        if (etudiant.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("userId", etudiant.get().getEtudiantID());
            response.put("userType", "Etudiant");
            return ResponseEntity.ok(response);
        }

        Optional<Professeur> professeur = professeurService.login(email, password);
        if (professeur.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("userId", professeur.get().getId());
            response.put("userType", "Professeur");
            return ResponseEntity.ok(response);
        }

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", "Login failed");
        return ResponseEntity.status(401).body(errorResponse);
    }

    
    
    private static class LoginRequest {
        private String email;
        private String password;
       

        public String getEmail() {
            return email;
        }

      
        public String getPassword() {
            return password;
        }

        
    }
}
