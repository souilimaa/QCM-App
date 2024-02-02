package com.example.QCM.entity;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "qcm_id", nullable = false)
    private QCM qcm;

    private String ennonce;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QCM getQcm() {
		return qcm;
	}

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public void setQcm(QCM qcm) {
		this.qcm = qcm;
	}

	public String getEnnonce() {
		return ennonce;
	}

	public void setEnnonce(String ennonce) {
		this.ennonce = ennonce;
	}
    

}
