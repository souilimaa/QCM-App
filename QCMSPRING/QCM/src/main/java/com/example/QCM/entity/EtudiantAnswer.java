package com.example.QCM.entity;

import jakarta.persistence.*;


@Entity
public class EtudiantAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    private Long idEtudiant;

    private Long idQCM;

    private int score;

	public EtudiantAnswer() {
		// TODO Auto-generated constructor stub
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public Long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public Long getIdQCM() {
		return idQCM;
	}

	public void setIdQCM(Long idQCM) {
		this.idQCM = idQCM;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

    // Constructors, getters, setters, and other annotations if needed

}