package com.btssio.projet1.classe;

public class Adherent {

	private int idAdherent;
	private String nom;
	private String nomDeNaissance;
	private String prenom;
	private String dateDeNaissance;
	private String nationalite;
	private String paysDeNaissance;
	private String genre;
	private String villeDeNaissance;
	private int cp;
	private String ville;
	private String adresse;
	private int numeroDeTelephone1;
	private int numeroDeTelephone2;
	private String courriel;
	private String nomPrenomLegal;
	private String arme;
	private String pratique;
	private String lateralité;
	private String categorie;
	private Boolean licenceFFE;
	private Boolean assurance;
	private Boolean seancesTir;
	private Boolean reducFamille;
	private int reducFamilleEmeMembre;
	private String aideMobil;

	public int getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomDeNaissance() {
		return nomDeNaissance;
	}

	public void setNomDeNaissance(String nomDeNaissance) {
		this.nomDeNaissance = nomDeNaissance;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getPaysDeNaissance() {
		return paysDeNaissance;
	}

	public void setPaysDeNaissance(String paysDeNaissance) {
		this.paysDeNaissance = paysDeNaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getVilleDeNaissance() {
		return villeDeNaissance;
	}

	public void setVilleDeNaissance(String villeDeNaissance) {
		this.villeDeNaissance = villeDeNaissance;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
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

	public int getNumeroDeTelephone1() {
		return numeroDeTelephone1;
	}

	public void setNumeroDeTelephone1(int numeroDeTelephone1) {
		this.numeroDeTelephone1 = numeroDeTelephone1;
	}

	public int getNumeroDeTelephone2() {
		return numeroDeTelephone2;
	}

	public void setNumeroDeTelephone2(int numeroDeTelephone2) {
		this.numeroDeTelephone2 = numeroDeTelephone2;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getNomPrenomLegal() {
		return nomPrenomLegal;
	}

	public void setNomPrenomLegal(String nomPrenomLegal) {
		this.nomPrenomLegal = nomPrenomLegal;
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Boolean getLicenceFFE() {
		return licenceFFE;
	}

	public void setLicenceFFE(Boolean licenceFFE) {
		this.licenceFFE = licenceFFE;
	}

	public Boolean getAssurance() {
		return assurance;
	}

	public void setAssurance(Boolean assurance) {
		this.assurance = assurance;
	}

	public Boolean getSeancesTir() {
		return seancesTir;
	}

	public void setSeancesTir(Boolean seancesTir) {
		this.seancesTir = seancesTir;
	}

	public Boolean getReducFamille() {
		return reducFamille;
	}

	public void setReducFamille(Boolean reducFamille) {
		this.reducFamille = reducFamille;
	}

	public int getReducFamilleEmeMembre() {
		return reducFamilleEmeMembre;
	}

	public void setReducFamilleEmeMembre(int reducFamilleEmeMembre) {
		this.reducFamilleEmeMembre = reducFamilleEmeMembre;
	}

	public String getAideMobil() {
		return aideMobil;
	}

	public void setAideMobil(String aideMobil) {
		this.aideMobil = aideMobil;
	}

	public Adherent(/*int idAdherent,*/ String nom, String nomDeNaissance, String prenom, String dateDeNaissance,
			String nationalite, String paysDeNaissance, String genre, String villeDeNaissance, int cp, String ville,
			String adresse, int numeroDeTelephone1, int numeroDeTelephone2, String courriel, String nomPrenomLegal,
			String arme, String pratique, String lateralité, String categorie, Boolean licenceFFE, Boolean assurance,
			Boolean seancesTir, Boolean reducFamille, int reducFamilleEmeMembre, String aideMobil) {
		super();
		//this.idAdherent = idAdherent;
		this.nom = nom;
		this.nomDeNaissance = nomDeNaissance;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.nationalite = nationalite;
		this.paysDeNaissance = paysDeNaissance;
		this.genre = genre;
		this.villeDeNaissance = villeDeNaissance;
		this.cp = cp;
		this.ville = ville;
		this.adresse = adresse;
		this.numeroDeTelephone1 = numeroDeTelephone1;
		this.numeroDeTelephone2 = numeroDeTelephone2;
		this.courriel = courriel;
		this.nomPrenomLegal = nomPrenomLegal;
		this.arme = arme;
		this.pratique = pratique;
		this.lateralité = lateralité;
		this.categorie = categorie;
		this.licenceFFE = licenceFFE;
		this.assurance = assurance;
		this.seancesTir = seancesTir;
		this.reducFamille = reducFamille;
		this.reducFamilleEmeMembre = reducFamilleEmeMembre;
		this.aideMobil = aideMobil;
	}
	
	public int calculPrix() {
		// definition des variable
		String[] annee = this.getDateDeNaissance().split("/"); //difinition d'une liste par split /
		int année = 0, tarif;
		
		// recuperation de l'année (definis jj/mm/aaaa)
		for (String anne : annee) {
			année = Integer.parseInt(anne);
        }
		
		// calcule du tarif sans licance par apor a l'année
		if (année > 2012) {
			tarif = 190;
		} else {
			if (année > 2003) {
				tarif = 220;
			} else { 
				tarif = 255;
			}
		}
		
		// ajout de la lissance a pori si il y a
		if (this.getLicenceFFE()) {
			if (année > 2016) {
				tarif = tarif + 28;
			} else {
				if (année > 20014) {
					tarif = tarif + 45;
				} else { 
					tarif = tarif + 55;
				}
			}
		}
		
		return tarif;
	}

}
