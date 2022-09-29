
package com.btssio.projet1.classe;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ecritureXML {
	public static void main(String argv[]) {
		try {
			String file = "src/xml/categorie.xml";
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);

			// Récupérer l'élément racine
			Node adherent = doc.getFirstChild();
			// Récupérer l'élément employee
			Node lesAdherent = doc.getElementsByTagName("adherent").item(0);
			// Modifier l'attribut employee id="1" à id="5"
			NamedNodeMap attr = lesAdherent.getAttributes();
			Node node = attr.getNamedItem("id");
			node.setTextContent("5");
			// écrire le contenu dans le fichier xml spécifié
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource src = new DOMSource(doc);
			StreamResult res = new StreamResult(new File(file));
			transformer.transform(src, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
