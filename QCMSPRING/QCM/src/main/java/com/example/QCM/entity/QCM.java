package com.example.QCM.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class QCM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professeur_id", nullable = false)
    private Professeur professeur;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "matiere_id", nullable = false)
    private Matiere matiere;
    
    private String titre;
    private String description;
    private int duree;
    private int nombreQst;
    private boolean choixMultiple;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

	public QCM(Professeur professeur, Matiere matiere, String titre, String description, int duree, int nombreQst,
			boolean choixMultiple, Date createdAt) {
		super();
		this.professeur = professeur;
		this.matiere = matiere;
		this.titre = titre;
		this.description = description;
		this.duree = duree;
		this.nombreQst = nombreQst;
		this.choixMultiple = choixMultiple;
		this.createdAt = createdAt;
	}

	public QCM() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNombreQst() {
		return nombreQst;
	}

	public void setNombreQst(int nombreQst) {
		this.nombreQst = nombreQst;
	}

	public boolean isChoixMultiple() {
		return choixMultiple;
	}

	public void setChoixMultiple(boolean choixMultiple) {
		this.choixMultiple = choixMultiple;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
