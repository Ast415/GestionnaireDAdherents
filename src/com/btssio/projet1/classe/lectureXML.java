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
	@SuppressWarnings("null")
	public static ArrayList<Club> importationXMLClub() throws ParserConfigurationException, SAXException {
		ArrayList<Club> lesClub = new ArrayList();
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
		ArrayList<categorie> lesCategorie = new ArrayList();
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

}
