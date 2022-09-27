package com.btssio.projet1.classe;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Program {
	public static void main(String[]args) throws ParserConfigurationException, SAXException {
		Adherent Adh1 = new Adherent(
				"BORIES",
				"Bastien",
				"Homme",
				"29/01/2002",
				"Castres",
				"Bastien",
				"Toulouse",
				"118 route de narbone",
				31400,
				"Fr",
				"0781878897",
				"0000000000",
				"Epee",
				"Escrime",
				"Droitier");
		ArrayList<Club> lesClub = new ArrayList();
		lesClub = lectureXML.importationXMLClub();
		for (Club elem : lesClub) { System.out.print(elem.getNom()+", "); }
	}

}
