package com.btssio.projet1.classe;

public class categorie {
	private int id;
	private String nom;
	private String code;
	private String annee_min;
	private String annee_max;

	public synchronized int getId() {
		return id;
	}

	public synchronized String getNom() {
		return nom;
	}

	public synchronized String getCode() {
		return code;
	}

	public synchronized String getAnnee_min() {
		return annee_min;
	}

	public synchronized String getAnnee_max() {
		return annee_max;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized void setNom(String nom) {
		this.nom = nom;
	}

	public synchronized void setCode(String code) {
		this.code = code;
	}

	public synchronized void setAnnee_min(String annee_min) {
		this.annee_min = annee_min;
	}

	public synchronized void setAnnee_max(String annee_max) {
		this.annee_max = annee_max;
	}

	public categorie(int id, String nom, String code, String annee_min, String annee_max) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
		this.annee_min = annee_min;
		this.annee_max = annee_max;
	}

}
