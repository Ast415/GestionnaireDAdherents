package com.btssio.projet1.classe;

public class Adherent {
	
	private String nom;
	private String prenom;
	private String genre;
	private String dateDeNaissance;
	private String villeDeNaissance;
	private String nomDeNaissance;
	private String ville;
	private String adresse;
	private int cp;
	private String nationalité;
	private String numeroDeTelephone1;
	private String numeroDeTelephone2;
	private String arme;
	private String pratique;
	private String lateralité;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getVilleDeNaissance() {
		return villeDeNaissance;
	}
	public void setVilleDeNaissance(String villeDeNaissance) {
		this.villeDeNaissance = villeDeNaissance;
	}
	public String getNomDeNaissance() {
		return nomDeNaissance;
	}
	public void setNomDeNaissance(String nomDeNaissance) {
		this.nomDeNaissance = nomDeNaissance;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getNationalité() {
		return nationalité;
	}
	public void setNationalité(String nationalité) {
		this.nationalité = nationalité;
	}
	public String getNumeroDeTelephone1() {
		return numeroDeTelephone1;
	}
	public void setNumeroDeTelephone1(String numeroDeTelephone1) {
		this.numeroDeTelephone1 = numeroDeTelephone1;
	}
	public String getNumeroDeTelephone2() {
		return numeroDeTelephone2;
	}
	public void setNumeroDeTelephone2(String numeroDeTelephone2) {
		this.numeroDeTelephone2 = numeroDeTelephone2;
	}
	public String getArme() {
		return arme;
	}
	public void setArme(String arme) {
		this.arme = arme;
	}
	public String getPratique() {
		return pratique;
	}
	public void setPratique(String pratique) {
		this.pratique = pratique;
	}
	public String getLateralité() {
		return lateralité;
	}
	public void setLateralité(String lateralité) {
		this.lateralité = lateralité;
	}
	
	
	public Adherent(String nom, String prenom, String genre, String dateDeNaissance, String villeDeNaissance,
			String nomDeNaissance, String ville, String adresse, int cp, String nationalité, String numeroDeTelephone1,
			String numeroDeTelephone2, String arme, String pratique, String lateralité) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.dateDeNaissance = dateDeNaissance;
		this.villeDeNaissance = villeDeNaissance;
		this.nomDeNaissance = nomDeNaissance;
		this.ville = ville;
		this.adresse = adresse;
		this.cp = cp;
		this.nationalité = nationalité;
		this.numeroDeTelephone1 = numeroDeTelephone1;
		this.numeroDeTelephone2 = numeroDeTelephone2;
		this.arme = arme;
		this.pratique = pratique;
		this.lateralité = lateralité;
	}
	public void SePresenter() {
		System.out.println("Je suis "+this.nom+" "+this.prenom);
	}
	

}
