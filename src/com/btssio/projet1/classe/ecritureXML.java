package com.btssio.projet1.classe;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.xml.parsers.*; 
import javax.xml.transform.*; 
import javax.xml.transform.dom.*; 
import javax.xml.transform.stream.*; 
import org.xml.sax.*; 
import org.w3c.dom.*;



public class ecritureXML {
	
	//convertire bool en string (1 vrais 0 faux)
	private static String trueOrFals(Boolean val) {
		String result;
		
		if (val) {
			result = "1";
		} else {
			result = "0";
		}
		
		return result;
	}
	
	//convetire int en string
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

	        Element rootEle = dom.createElement("adherent");
	        Element uneEntite = dom.createElement("adherent");
	        
	        
	        
	        
	        // create data elements and place them under root
	        e = dom.createElement("nom");
	        e.appendChild(dom.createTextNode(newAdherent.getNom()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("nomDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getNomDeNaissance()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("prenom");
	        e.appendChild(dom.createTextNode(newAdherent.getPrenom()));
	        uneEntite.appendChild(e);

	        e = dom.createElement("dateDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getDateDeNaissance()));
	        uneEntite.appendChild(e);
	        
            //System.out.println(newAdherent.getNom().getClass());
            //System.out.println(dom.createTextNode(newAdherent.getNom()).getClass());
            //System.out.println(e.getClass());
            //System.out.println(dom.getClass());
            //System.out.println("----------------------------");
            //System.out.println(rootEle.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
	        
	        e = dom.createElement("nationalite");
	        e.appendChild(dom.createTextNode(newAdherent.getNationalite()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("paysDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getPaysDeNaissance()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("genre");
	        e.appendChild(dom.createTextNode(newAdherent.getGenre()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("villeDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getVilleDeNaissance()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("cp");
	        e.appendChild(dom.createTextNode(intToString(newAdherent.getCp())));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("ville");
	        e.appendChild(dom.createTextNode(newAdherent.getVille()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("adresse");
	        e.appendChild(dom.createTextNode(newAdherent.getAdresse()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("numeroDeTelephone1");
	        e.appendChild(dom.createTextNode(intToString(newAdherent.getNumeroDeTelephone1())));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("numeroDeTelephone2");
	        e.appendChild(dom.createTextNode(intToString(newAdherent.getNumeroDeTelephone2())));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("courriel");
	        e.appendChild(dom.createTextNode(newAdherent.getCourriel()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("nomPrenomLegal");
	        e.appendChild(dom.createTextNode(newAdherent.getNomPrenomLegal()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("arme");
	        e.appendChild(dom.createTextNode(newAdherent.getArme()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("pratique");
	        e.appendChild(dom.createTextNode(newAdherent.getPratique()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("lateralite");
	        e.appendChild(dom.createTextNode(newAdherent.getLateralité()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("categorie");
	        e.appendChild(dom.createTextNode(newAdherent.getCategorie()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("licenceFFE");
	        e.appendChild(dom.createTextNode(trueOrFals(newAdherent.getLicenceFFE())));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("assurance");
	        e.appendChild(dom.createTextNode(trueOrFals(newAdherent.getAssurance())));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("seancesTir");
	        e.appendChild(dom.createTextNode(trueOrFals(newAdherent.getSeancesTir())));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("reducFamille");
	        e.appendChild(dom.createTextNode(trueOrFals(newAdherent.getReducFamille())));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("reducFamilleEmeMembre");
	        e.appendChild(dom.createTextNode(intToString(newAdherent.getReducFamilleEmeMembre())));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("aideMobil");
	        e.appendChild(dom.createTextNode(newAdherent.getAideMobil()));
	        uneEntite.appendChild(e);
	        
	        //_____________________________
	        
	        //e = dom.createElement("adherent");
	        //e.appendChild(rootEle);
	        //test.appendChild(e);
	        
	        Attr attr = dom.createAttribute("id");
	        attr.setValue("0");
	        uneEntite.setAttributeNode(attr);
	        
	        rootEle.appendChild(uneEntite);
	        
	        //test pour verifier le contenue
	        //for (int i=0; i<rootEle.getChildNodes().getLength() ; i++) {
	        //	System.out.println(rootEle.getChildNodes().item(i).getChildNodes().item(0).getNodeValue());
	        //}
	        
	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            //tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	            tr.setOutputProperty("{http://xml.Apache.org/xslt}indent-amount", "4");
	            
	            //test
	            System.out.println("connexion fichier");
	            
	            // send DOM to file
	            tr.transform(new DOMSource(rootEle), new StreamResult(new FileOutputStream("src/xml/adherent.xml")));
	            
	            //test
	    	    System.out.println("connexion ok");
	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	            
	            //test
		        System.out.println("pas ok");
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
