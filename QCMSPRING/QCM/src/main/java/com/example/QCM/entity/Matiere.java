package com.example.QCM.entity;

import jakarta.persistence.*;

@Entity
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

	public Long getId() {
		return id;
	}

	public Matiere() {

	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Matiere(String nom) {
		super();
		this.nom = nom;
	}
    

}
