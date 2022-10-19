package com.btssio.projet1.classe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class lectureXML {
	public static ArrayList<Club> importationXMLClub() throws ParserConfigurationException, SAXException {
		ArrayList<Club> lesClub = new ArrayList<Club>();
		Club newClub;

		try {
			File file = new File("src/xml/club.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();

			NodeList nList = document.getElementsByTagName("club");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					newClub = new Club(Integer.parseInt(eElement.getAttribute("id")),
							eElement.getElementsByTagName("nom").item(0).getTextContent(),
							eElement.getElementsByTagName("adresse").item(0).getTextContent(),
							eElement.getElementsByTagName("contact").item(0).getTextContent(),
							eElement.getElementsByTagName("tel").item(0).getTextContent(),
							eElement.getElementsByTagName("mail").item(0).getTextContent(),
							eElement.getElementsByTagName("site").item(0).getTextContent());

					lesClub.add(newClub);

				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		/*
		 * for (Club elem : lesClub) { System.out.println(elem.getId()); }
		 */
		return lesClub;
	}

	public static ArrayList<categorie> importationXMLCategories() throws ParserConfigurationException, SAXException {
		ArrayList<categorie> lesCategorie = new ArrayList<categorie>();
		categorie newcategorie;

		try {
			File file = new File("src/xml/categorie.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();

			NodeList nList = document.getElementsByTagName("categorie");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					newcategorie = new categorie(Integer.parseInt(eElement.getAttribute("id")),
							eElement.getElementsByTagName("nom").item(0).getTextContent(),
							eElement.getElementsByTagName("code").item(0).getTextContent(),
							eElement.getElementsByTagName("annee_min").item(0).getTextContent(),
							eElement.getElementsByTagName("annee_max").item(0).getTextContent());

					lesCategorie.add(newcategorie);

				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return lesCategorie;
	}
	
	//Permet de lire le fichier xml de adherent, mais retourne directement sous la meme forme dans une variable
	public static Element importationBrutXMLadherent() throws ParserConfigurationException, SAXException{
		
		try {

			File file = new File("src/xml/adherent.xml");//choisi le fichier a lire
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();

			NodeList nList = document.getElementsByTagName("adherent");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//supprime les lignes vides
					for (int i=0;i<eElement.getChildNodes().getLength()-1;i++) {
			        	if (eElement.getChildNodes().item(i).getNodeName()=="#text") {
			        		eElement.removeChild(eElement.getChildNodes().item(i));
			        	}
			        	for (int j=0;j<eElement.getChildNodes().item(i).getChildNodes().getLength();j++) {
			        		if (eElement.getChildNodes().item(i).getChildNodes().item(j).getNodeName()=="#text") {
			        			eElement.getChildNodes().item(i).removeChild(eElement.getChildNodes().item(i).getChildNodes().item(j));
				        	}
			        	}
			        }
					//supprime la derniere ligne vide
					if(eElement.getLastChild().getNodeName()=="#text") {
						eElement.removeChild(eElement.getLastChild());
					}
					
					return eElement;
					
				}
			}
					
		}catch (IOException e) {
			System.out.println(e);
		}
		
		return null;
		
		
	}

	public static ArrayList<Adherent> importationXMLadherent() throws ParserConfigurationException, SAXException {
		ArrayList<Adherent> lesAdherent = new ArrayList<Adherent>();
		Adherent newcategorie;
		boolean licenceFFE, assurance, seancesTir, reducFamille;

		try {

			File file = new File("src/xml/adherent.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();

			NodeList nList = document.getElementsByTagName("adherent");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					if(eElement.getChildNodes().getLength()==1) {
						return null;
					}

					if (eElement.getElementsByTagName("licenceFFE").item(0).getTextContent() == "1") {
						licenceFFE = true;
					} else {
						licenceFFE = false;
					}
					if (eElement.getElementsByTagName("assurance").item(0).getTextContent() == "1") {
						assurance = true;
					} else {
						assurance = false;
					}
					if (eElement.getElementsByTagName("seancesTir").item(0).getTextContent() == "1") {
						seancesTir = true;
					} else {
						seancesTir = false;
					}
					if (eElement.getElementsByTagName("reducFamille").item(0).getTextContent() == "1") {
						reducFamille = true;
					} else {
						reducFamille = false;
					}

					newcategorie = new Adherent(
							eElement.getElementsByTagName("nom").item(0).getTextContent(),
							eElement.getElementsByTagName("nomDeNaissance").item(0).getTextContent(),
							eElement.getElementsByTagName("prenom").item(0).getTextContent(),
							eElement.getElementsByTagName("dateDeNaissance").item(0).getTextContent(),
							eElement.getElementsByTagName("paysDeNaissance").item(0).getTextContent(),
							eElement.getElementsByTagName("nationalite").item(0).getTextContent(),
							eElement.getElementsByTagName("genre").item(0).getTextContent(),
							eElement.getElementsByTagName("villeDeNaissance").item(0).getTextContent(),
							Integer.parseInt(eElement.getElementsByTagName("cp").item(0).getTextContent()),
							eElement.getElementsByTagName("ville").item(0).getTextContent(),
							eElement.getElementsByTagName("adresse").item(0).getTextContent(),
							Integer.parseInt(
									eElement.getElementsByTagName("numeroDeTelephone1").item(0).getTextContent()),
							Integer.parseInt(
									eElement.getElementsByTagName("numeroDeTelephone2").item(0).getTextContent()),
							eElement.getElementsByTagName("courriel").item(0).getTextContent(),
							eElement.getElementsByTagName("nomPrenomLegal").item(0).getTextContent(),
							eElement.getElementsByTagName("arme").item(0).getTextContent(),
							eElement.getElementsByTagName("pratique").item(0).getTextContent(),
							eElement.getElementsByTagName("lateralite").item(0).getTextContent(),
							eElement.getElementsByTagName("categorie").item(0).getTextContent(), licenceFFE, assurance,
							seancesTir, reducFamille,
							Integer.parseInt(
									eElement.getElementsByTagName("reducFamilleEmeMembre").item(0).getTextContent()),
							eElement.getElementsByTagName("aideMobil").item(0).getTextContent());

					lesAdherent.add(newcategorie);

				}
			}
		} catch (IOException e) {
			System.out.println("5");
			System.out.println(e);
		}

		for (Adherent elem : lesAdherent) {
			System.out.println(elem.getIdAdherent());
		}

		return lesAdherent;
	}
	
	public static void main(String[]args) throws ParserConfigurationException, SAXException {
		importationXMLadherent();
	}

}
