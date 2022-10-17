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
	        Element xmlFile = dom.createElement("adherent");
			try {
				xmlFile = lectureXML.importationBrutXMLadherent();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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

	        /*System.out.println("test : "+rootEle.getChildNodes().getLength());
	        System.out.println("test : "+uneEntite.getChildNodes().getLength());
	        //uneEntite2.appendChild(uneEntite.getChildNodes().item(0));
	        rootEle.appendChild(dom.createElement(xmlFile.getChildNodes().item(0).getNodeName()));
	        rootEle.getChildNodes().item(0).appendChild(dom.createElement(xmlFile.getChildNodes().item(0).getChildNodes().item(0).getNodeName()));
	        System.out.println(rootEle.getChildNodes().item(0).getChildNodes().item(0).getNodeName());
	        */
	        
	        for (int i=0; i<xmlFile.getChildNodes().getLength(); i++) {
	        	e = dom.createElement(xmlFile.getChildNodes().item(i).getNodeName());
	        	e.setAttribute("id", intToString(i));
	        	rootEle.appendChild(e);
		        
		        for(int j=0;j<xmlFile.getChildNodes().item(i).getChildNodes().getLength();j++) {
		        	rootEle.getChildNodes().item(i).appendChild(dom.createElement(xmlFile.getChildNodes().item(i).getChildNodes().item(j).getNodeName()));
		        	rootEle.getChildNodes().item(i).getChildNodes().item(j).appendChild(dom.createTextNode(xmlFile.getChildNodes().item(i).getChildNodes().item(j).getTextContent()));
		        }
		        
	        }
        	uneEntite.setAttribute("id", intToString(xmlFile.getChildNodes().getLength()));
	        rootEle.appendChild(uneEntite);
	        //rootEle = dom.createElement("adherent");
	        
	        
	        //uneEntite2.setAttribute("id", "1");
	        //rootEle.appendChild(uneEntite2);
	        
	        
	        /*for (int j=1;j<4;j++) {
	        	String nb = intToString(j);
	        	e = dom.createElement("adherent");
	        	e.setAttribute("id", nb);
	        	rootEle.appendChild(e);
	        	//try {
	        	//	System.out.println(nb+" : "+rootEle.getElementsByTagName("test").item(j-1).getAttributes());
	        	//}catch (Exception e1) {
	        	//	System.out.println("err");
	        	//}
	        	
		        //rootEle.getElementsByTagName("test").item(0).appendChild(dom.createTextNode("test"));
		        
		        for (int i=0; i<25 ; i++) {
		        	String eName = uneEntite.getChildNodes().item(i).getNodeName();
		        	//System.out.println(uneEntite.getChildNodes().getLength()+" "+i);
		        	String eVal = uneEntite.getChildNodes().item(i).getChildNodes().item(0).getNodeValue();
		        	//System.out.println(eVal);
		        	rootEle.getElementsByTagName("adherent").item(j).appendChild(dom.createElement(eName));
		        	rootEle.getElementsByTagName("adherent").item(j).getChildNodes().item(i).appendChild(dom.createTextNode(eVal));

		        }
	        }*/
	        
			//System.out.println(rootEle.getChildNodes().getLength());

	        
	        
	        //rootEle.appendChild(dom.createElement("test"));
	        
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
