package com.example.QCM.entity;

import jakarta.persistence.*;

@Entity
public class Choix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Choix() {
		// TODO Auto-generated constructor stub
	}
	private String choixEnonce;
    private boolean isCorrect;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getChoixEnonce() {
		return choixEnonce;
	}
	public void setChoixEnonce(String choixEnonce) {
		this.choixEnonce = choixEnonce;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}
