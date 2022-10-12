package com.btssio.projet1.classe;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.*; 
import javax.xml.transform.*; 
import javax.xml.transform.dom.*; 
import javax.xml.transform.stream.*; 
import org.xml.sax.*; 
import org.w3c.dom.*;



public class ecritureXML {
	private static String trueOrFals(Boolean val) {
		String result;
		
		if (val) {
			result = "1";
		} else {
			result = "0";
		}
		
		return result;
	}
	
	private static String intToString(int val) {
		String result;
		
		result = val+"";
		
		return result;
	}
	
	public static void newAdherant(Adherent newAdherent) throws IOException {
		Document dom;
	    Element e = null;

	    // instance of a DocumentBuilderFactory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	        // use factory to get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        // create instance of DOM
	        dom = db.newDocument();

	        // create the root element
	        Element rootEle = dom.createElement("adherents");
	        
	        // create data elements and place them under root
	        e = dom.createElement("nom");
	        e.appendChild(dom.createTextNode(newAdherent.getNom()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("prenom");
	        e.appendChild(dom.createTextNode(newAdherent.getPrenom()));
	        rootEle.appendChild(e);

	        e = dom.createElement("dateDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getDateDeNaissance()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("nationalite");
	        e.appendChild(dom.createTextNode(newAdherent.getNationalite()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("paysDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getPaysDeNaissance()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("genre");
	        e.appendChild(dom.createTextNode(newAdherent.getGenre()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("villeDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getVilleDeNaissance()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("cp");
	        e.appendChild(dom.createTextNode(intToString(newAdherent.getCp())));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("ville");
	        e.appendChild(dom.createTextNode(newAdherent.getVille()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("adresse");
	        e.appendChild(dom.createTextNode(newAdherent.getAdresse()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("numeroDeTelephone1");
	        e.appendChild(dom.createTextNode(intToString(newAdherent.getNumeroDeTelephone1())));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("numeroDeTelephone2");
	        e.appendChild(dom.createTextNode(intToString(newAdherent.getNumeroDeTelephone2())));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("courriel");
	        e.appendChild(dom.createTextNode(newAdherent.getCourriel()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("nomPrenomLegal");
	        e.appendChild(dom.createTextNode(newAdherent.getNomPrenomLegal()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("arme");
	        e.appendChild(dom.createTextNode(newAdherent.getArme()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("pratique");
	        e.appendChild(dom.createTextNode(newAdherent.getPratique()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("lateralite");
	        e.appendChild(dom.createTextNode(newAdherent.getLateralité()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("categorie");
	        e.appendChild(dom.createTextNode(newAdherent.getCategorie()));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("licenceFFE");
	        e.appendChild(dom.createTextNode(trueOrFals(newAdherent.getLicenceFFE())));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("assurance");
	        e.appendChild(dom.createTextNode(trueOrFals(newAdherent.getAssurance())));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("seancesTir");
	        e.appendChild(dom.createTextNode(trueOrFals(newAdherent.getSeancesTir())));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("reducFamille");
	        e.appendChild(dom.createTextNode(trueOrFals(newAdherent.getReducFamille())));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("reducFamilleEmeMembre");
	        e.appendChild(dom.createTextNode(intToString(newAdherent.getReducFamilleEmeMembre())));
	        rootEle.appendChild(e);
	        
	        e = dom.createElement("aideMobil");
	        e.appendChild(dom.createTextNode(newAdherent.getAideMobil()));
	        rootEle.appendChild(e);
	        
	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	            tr.setOutputProperty("{http://xml.Apache.org/xslt}indent-amount", "4");
	            
	            //test
	            System.out.println("1");
	            
	            // send DOM to file
	            tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream("xml")));
	            
	            //test
	    	    System.out.println("2");
	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	            
	            //test
		        System.out.println("3");
	        }
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	}
	
	public static void main(String[]args) throws ParserConfigurationException, SAXException, IOException {
		Adherent test = new Adherent( null, null, null, null, null, null, null, null, 0, null, null, 0, 0, null, null, null, null, null, null, true, true, true, true, 0, null);
		newAdherant(test);
		
	}
}
