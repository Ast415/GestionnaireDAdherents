package com.btssio.projet1.graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.btssio.projet1.classe.Adherent;
import com.btssio.projet1.classe.categorie;
import com.btssio.projet1.classe.lectureXML;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.util.regex.*;
import java.awt.Toolkit;

public class JFformulaireAfficher extends JFrame {

	private JPanel contentPane;
	private JTextField txtfAffIDAdh;
	private JTextPane txtpAffResultatAdh;
	private JTextPane txtpAffResultatCat;
	protected static boolean formEstOuvert = false;//Variable permettant de déterminer si la fenêtre est ouverte ou non 
	private ArrayList<Adherent> lesAdherent = new ArrayList<Adherent>();
	private ArrayList<categorie> lesCategorie = new ArrayList<categorie>();
	
	public void init() {

		try {
			//Importe les adherent du fichier xml et les place dans la liste lesAdherent
			lesAdherent=lectureXML.importationXMLadherent();
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//Importe les adherent du fichier xml et les place dans la liste lesAdherent
			lesCategorie=lectureXML.importationXMLCategories();
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String booleanVersOuiNon (boolean unEtat) {
		if(unEtat==true) {
			return "Oui";
		}else {
			return "Non";
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFformulaireAfficher frame = new JFformulaireAfficher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFformulaireAfficher() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFformulaireAfficher.class.getResource("/img/logoM1Icon.png")));
		setTitle("Afficher un adhérent");
		setResizable(false);
		addWindowListener(new WindowAdapter() {//S'exécute comment ferme la fenêtre
			@Override
			public void windowClosed(WindowEvent e) {
				formEstOuvert=false;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 761, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAffValider = new JButton("Valider");
		btnAffValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Pattern.matches("[0-9]+", txtfAffIDAdh.getText())) {
					//Hé on va récupérer la valeur qu'il y a dans le champ 
					int idAdherent = Integer.valueOf(txtfAffIDAdh.getText())+1;
					//Si cette valeur est une entité dans la liste des adhérents alors on affiche ces informations
					//Hé dans la liste adhérent la position de l'adhérent est son identifiant sont la même chose 
					if (idAdherent<lesAdherent.size() && idAdherent>=0) {
						txtpAffResultatAdh.setForeground(new Color(0, 0, 0));//Mets la couleur du texte en noir 
						txtpAffResultatAdh.setText(
								  "Nom : "+lesAdherent.get(idAdherent).getNom()
								+ "\nPrenom : "+lesAdherent.get(idAdherent).getPrenom()
								+ "\nDate de naissance : "+lesAdherent.get(idAdherent).getDateDeNaissance()
								+ "\nGenre : "+lesAdherent.get(idAdherent).getGenre()
								+ "\nVille : "+lesAdherent.get(idAdherent).getVille()
								+ "\nCode postal : "+lesAdherent.get(idAdherent).getCp()
								+ "\nAdresse : "+lesAdherent.get(idAdherent).getAdresse()
								+ "\nNuméro de téléphone 1 : 0"+lesAdherent.get(idAdherent).getNumeroDeTelephone1()
								+ "\nNuméro de téléphone 2 : 0"+lesAdherent.get(idAdherent).getNumeroDeTelephone2()
								+ "\nCourriel : "+lesAdherent.get(idAdherent).getCourriel()
								+ "\nArme : "+lesAdherent.get(idAdherent).getArme()
								+ "\nPratique : "+lesAdherent.get(idAdherent).getPratique()
								+ "\nLatéralité : "+lesAdherent.get(idAdherent).getLateralité()
								+ "\nCatégotrie : "+lesAdherent.get(idAdherent).getCategorie()
								+ "\nLicence : "+booleanVersOuiNon(lesAdherent.get(idAdherent).getLicenceFFE()));
					}else {
						txtpAffResultatAdh.setForeground(new Color(213, 26, 0));//Hé mets la couleur du texte en rouge 
						txtpAffResultatAdh.setText("Cet identifiant n'est pas reconnu, veuillez essayer un autre identifiant ");
					}
					for (int i=0; i<lesCategorie.size();i++) {
						if (lesCategorie.get(i).getNom().equals(lesAdherent.get(idAdherent).getCategorie())) {
							txtpAffResultatCat.setText(
									"Identifiant : "+lesCategorie.get(i).getId()
									+"\nCode : "+lesCategorie.get(i).getCode()
									+"\nTitre : "+lesCategorie.get(i).getNom()
									+"\nPeriode minimum : "+lesCategorie.get(i).getAnnee_min()
									+"\nPeriode maximum : "+lesCategorie.get(i).getAnnee_max()
									);
						}
					}
					if (txtpAffResultatCat.getText().equals("")) {
						txtpAffResultatCat.setText("C'est catégorie n'est pas référencer");
					}
				}else {
					JOptionPane.showMessageDialog(contentPane,"Ce qui est saisi dans le champ n'est pas une valeur");
				}
			}
		});
		btnAffValider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAffValider.setBounds(261, 507, 160, 38);
		contentPane.add(btnAffValider);
		
		txtfAffIDAdh = new JTextField();
		txtfAffIDAdh.setBounds(10, 151, 319, 27);
		contentPane.add(txtfAffIDAdh);
		txtfAffIDAdh.setColumns(10);
		
		JLabel lblAffIDAdh = new JLabel("Saisir l'identifiant d'un adhérent");
		lblAffIDAdh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAffIDAdh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAffIDAdh.setBounds(10, 102, 319, 38);
		contentPane.add(lblAffIDAdh);
		
		JLabel lblAfficherUnAdhrent = new JLabel("Afficher un adhérent");
		lblAfficherUnAdhrent.setToolTipText("Afficher un adhérent");
		lblAfficherUnAdhrent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfficherUnAdhrent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAfficherUnAdhrent.setBounds(10, 11, 725, 38);
		contentPane.add(lblAfficherUnAdhrent);
		
		txtpAffResultatAdh = new JTextPane();
		txtpAffResultatAdh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpAffResultatAdh.setEditable(false);
		txtpAffResultatAdh.setBounds(339, 151, 396, 302);
		contentPane.add(txtpAffResultatAdh);
		init();
		
		JLabel lblAffIDAdhNb = new JLabel("Il existe "+(lesAdherent.size()-1)+" adhérents ");
		lblAffIDAdhNb.setHorizontalAlignment(SwingConstants.CENTER);
		lblAffIDAdhNb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAffIDAdhNb.setBounds(10, 189, 319, 38);
		contentPane.add(lblAffIDAdhNb);
		
		txtpAffResultatCat = new JTextPane();
		txtpAffResultatCat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpAffResultatCat.setEditable(false);
		txtpAffResultatCat.setBounds(10, 287, 319, 166);
		contentPane.add(txtpAffResultatCat);
		
		JLabel lblAffIDAdh_1 = new JLabel("Information de l'adherent");
		lblAffIDAdh_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAffIDAdh_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAffIDAdh_1.setBounds(339, 102, 396, 38);
		contentPane.add(lblAffIDAdh_1);
		
		JLabel lblInformationSura = new JLabel("Information sur ça catégorie");
		lblInformationSura.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformationSura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformationSura.setBounds(10, 238, 319, 38);
		contentPane.add(lblInformationSura);
		
	}
}
