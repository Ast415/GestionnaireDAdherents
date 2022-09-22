package com.btssio.projet1.classe;

import java.util.ArrayList;

public class Club {
	private int id;
	private String nom;
	private String adresse;
	private String contact;
	private String tel;
	private String mail;
	private String site;
	private ArrayList<Adherent> listAdherent;

	public synchronized int getId() {
		return id;
	}

	public synchronized String getNom() {
		return nom;
	}

	public synchronized String getAdresse() {
		return adresse;
	}

	public synchronized String getContact() {
		return contact;
	}

	public synchronized String getTel() {
		return tel;
	}

	public synchronized String getMail() {
		return mail;
	}

	public synchronized String getSite() {
		return site;
	}

	public synchronized ArrayList<Adherent> getListAdherent() {
		return listAdherent;
	}

	public synchronized void setListAdherent(ArrayList<Adherent> listAdherent) {
		this.listAdherent = listAdherent;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized void setNom(String nom) {
		this.nom = nom;
	}

	public synchronized void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public synchronized void setContact(String contact) {
		this.contact = contact;
	}

	public synchronized void setTel(String tel) {
		this.tel = tel;
	}

	public synchronized void setMail(String mail) {
		this.mail = mail;
	}

	public synchronized void setSite(String site) {
		this.site = site;
	}

	public Club(int id, String nom, String adresse, String contact, String tel, String mail, String site) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.contact = contact;
		this.tel = tel;
		this.mail = mail;
		this.site = site;
	}

	public Club(int id) {
		super();
		this.id = id;
	}

	public boolean addAdherent(Adherent newAdherent) {
		this.listAdherent.add(newAdherent);
		return this.listAdherent.contains(newAdherent);
	}

	public boolean supAdherent(Adherent supAdherent) {
		return this.listAdherent.remove(supAdherent);
	}

}
