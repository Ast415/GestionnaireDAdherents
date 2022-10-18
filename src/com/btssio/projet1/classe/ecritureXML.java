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
	        
	        //Contiendra le fichier adherent.xml + les nouvelle adherent du formulaire
	        Element rootEle = dom.createElement("adherent");
	        //Contiendra le fichier adherent.xml
	        Element xmlFile = dom.createElement("adherent");
			try {
				xmlFile = lectureXML.importationBrutXMLadherent();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//les element du nouvelle adherent
	        Element uneEntite = dom.createElement("adherent");
	        
	        
	        
	        
	        // create data elements and place them under root
	        e = dom.createElement("nom");//Cree un element "Nom"
	        e.appendChild(dom.createTextNode(newAdherent.getNom()));//Ajoute pour l'element "Nom" la valeur de newAdherent.getNom()
	        uneEntite.appendChild(e);//Ajoute c'est element et ça valeur dans uneEntite
	        
	        e = dom.createElement("nomDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getNomDeNaissance()));
	        uneEntite.appendChild(e);
	        
	        e = dom.createElement("prenom");
	        e.appendChild(dom.createTextNode(newAdherent.getPrenom()));
	        uneEntite.appendChild(e);

	        e = dom.createElement("dateDeNaissance");
	        e.appendChild(dom.createTextNode(newAdherent.getDateDeNaissance()));
	        uneEntite.appendChild(e);
	        
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
	        
	        //Transfert tout le contenue de xmlFile vers rootEle
	        //On ne peut pas faire rootEle==xmlFile car il ne sont pas dans le meme document (la variable)
	        //Dans un premiere temps on fait les node mere (qui possede un id)
	        for (int i=0; i<xmlFile.getChildNodes().getLength(); i++) {
	        	e = dom.createElement(xmlFile.getChildNodes().item(i).getNodeName());//recupere le nom de la node mere et crea un nouveau element avec pour rootEle
	        	e.setAttribute("id", intToString(i));//defini comme attribue de ce nouvelle element le meme que le node meme recup
	        	rootEle.appendChild(e);//On l'ajoute
		        
	        	//Puis on traite le contenue des node mere, les node fille et leurs valeur (Ex : [Nom : Bories; Prenom : Bastien)
		        for(int j=0;j<xmlFile.getChildNodes().item(i).getChildNodes().getLength();j++) {
		        	//On cree un element a partir du nom de la node fille et l'ajoute dans la node mere i
		        	rootEle.getChildNodes().item(i).appendChild(dom.createElement(xmlFile.getChildNodes().item(i).getChildNodes().item(j).getNodeName()));
		        	//On ajoute a c'est element la valeur de la node fille
		        	rootEle.getChildNodes().item(i).getChildNodes().item(j).appendChild(dom.createTextNode(xmlFile.getChildNodes().item(i).getChildNodes().item(j).getTextContent()));
		        }
	        }
	        //En fois fini rootEle et xmlFile on le meme contenue mais pas le meme document (la variable)
	        
	        //Ajoute les information du formulaire a rootEle
        	uneEntite.setAttribute("id", intToString(xmlFile.getChildNodes().getLength()));//Donne un identifient qui n'exsiste pas
	        rootEle.appendChild(uneEntite);
	        
	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            //Definie les propriete du fichier XML a cree
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty("{http://xml.Apache.org/xslt}indent-amount", "4");
	            
	            //test
	            System.out.println("connexion fichier");
	            
	            // send DOM to file
	            //Ecrase le fichier adherent.xml par un nouveau adherent.xml contenent rootEle 
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
