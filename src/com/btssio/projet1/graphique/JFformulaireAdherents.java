package com.btssio.projet1.graphique;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.btssio.projet1.classe.Adherent;
import com.btssio.projet1.classe.lectureXML;
import com.btssio.projet1.classe.ecritureXML;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class JFformulaireAdherents extends JFrame {

	//Zone de saisie 
	private JPanel contentPane;
	private JTextField txtfAdhNom;
	private JTextField txtfAdhPrenom;
	private JTextField txtfAdhNomNaiss;
	private JTextField txtfAdhDateNaissJ;
	private JTextField txtfAdhDateNaissM;
	private JTextField txtfAdhDateNaissA;
	private JTextField txtfAdhPaysNaiss;
	private JTextField txtfAdhVilleNaiss;
	private JTextField txtfAdhAdresse;
	private JTextField txtfAdhCP;
	private JTextField txtfAdhVille;
	private JTextField txtfAdhTel1;
	private JTextField txtfAdhTel2;
	private JTextField txtfAdhCourriel;
	private JTextField txtfAdhNomPrenomLeg;
	private JTextField txtfAdhNationalite;
	//Les groupes des boutons radio 
	private final ButtonGroup bgrGenre = new ButtonGroup();
	private final ButtonGroup bgrArme = new ButtonGroup();
	private final ButtonGroup bgrLateralite = new ButtonGroup();
	private final ButtonGroup bgrFFE = new ButtonGroup();
	private final ButtonGroup bgrAssurence = new ButtonGroup();
	private final ButtonGroup bgrReducFamille = new ButtonGroup();
	private final ButtonGroup bgrSeanceTir = new ButtonGroup();
	private final ButtonGroup bgrPratique = new ButtonGroup();
	protected static boolean formEstOuvert = false;//Variable permettant de déterminer si la fenêtre est ouverte ou non 
	private List<JTextField> LesTxtfASaisir = new ArrayList<JTextField>();
	private boolean formulaireComplete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFformulaireAdherents frame = new JFformulaireAdherents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void init() {//Voir à la fin du programme 
		AjoutDesTxtfASaisir();
		formulaireComplete = true;
	}
	
	public void AjoutDesTxtfASaisir() {//Liste des zones de texte à saisir obligatoirement 
		LesTxtfASaisir.add(txtfAdhNom);
		LesTxtfASaisir.add(txtfAdhPrenom);
		LesTxtfASaisir.add(txtfAdhAdresse);
		LesTxtfASaisir.add(txtfAdhDateNaissJ);
		LesTxtfASaisir.add(txtfAdhDateNaissM);
		LesTxtfASaisir.add(txtfAdhDateNaissA);
		LesTxtfASaisir.add(txtfAdhPaysNaiss);
		LesTxtfASaisir.add(txtfAdhVilleNaiss);
		LesTxtfASaisir.add(txtfAdhCP);
		LesTxtfASaisir.add(txtfAdhVille);
		LesTxtfASaisir.add(txtfAdhTel1);
		LesTxtfASaisir.add(txtfAdhCourriel);
		LesTxtfASaisir.add(txtfAdhNationalite);
		
	}
	
	//Permet de déterminer si la valeur du champ êtes une valeur entiere
	public boolean estUneValeurEntiere(JTextField UnChampDeText) {
		try {
			int i = Integer.valueOf(UnChampDeText.getText());
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	//Verifie que la taille de la valeur d'un champ soit bonne en fonction de certains paramètres 
	public boolean bonneTaille(JTextField UnChampDeText, int LaTailleMin, int LaTailleMax) {
		if(UnChampDeText.getText().length()<LaTailleMin || UnChampDeText.getText().length()>LaTailleMax) {
			return false;
		}else {
			return true;
		}
		
	}
	
	//Hé on vérifie que la valeur d'un champ le dépasse pas un minimum et maximum 
	public boolean bonneEtendue(JTextField UnChampDeText, int LaTailleMin, int LaTailleMax) {
		if(Integer.valueOf(UnChampDeText.getText())<LaTailleMin || Integer.valueOf(UnChampDeText.getText())>LaTailleMax) {
			return false;
		}else {
			return true;
		}
	}
	
	//Hé l'ensemble des tests de chanp qui besoin d'avoir une taille précise 
	public boolean tousDeBonneTaille() {
		boolean verification;
		verification = bonneTaille(txtfAdhCP,5,5);
		if (verification == true) {
			verification = bonneTaille(txtfAdhDateNaissJ,1,2);
		}
		if (verification == true) {
			verification = bonneTaille(txtfAdhDateNaissM,1,2);
		}
		if (verification == true) {
			verification = bonneTaille(txtfAdhDateNaissA,4,4);
		}
		if (verification == true) {
			verification = bonneTaille(txtfAdhTel1,10,10);
		}
		
		return verification;
	}
	
	//Ensemble de tests qui vérifie que ces champs hé sois bien dans l'étendue indiquée 
	public boolean tousOnUneBonneEtendue() {
		boolean verification;
		verification = bonneEtendue(txtfAdhDateNaissJ,1,31);
		if (verification == true) {
			verification = bonneEtendue(txtfAdhDateNaissM,1,12);
		}
		if (verification == true) {
			verification = bonneEtendue(txtfAdhDateNaissA,1900,2100);
		}
		return verification;
	}
	
	//Hé ensemble de tests qui vérifient que tous les champs tester soient bien des valeurs entières 
	public boolean tousSontDesValeurEntiere() {
		boolean verification;
		verification = estUneValeurEntiere(txtfAdhDateNaissJ);
		if (verification == true) {
			verification = estUneValeurEntiere(txtfAdhDateNaissM);
		}
		if (verification == true) {
			verification = estUneValeurEntiere(txtfAdhDateNaissA);
		}
		if (verification == true) {
			verification = estUneValeurEntiere(txtfAdhTel1);
		}
		if (verification == true) {
			verification = estUneValeurEntiere(txtfAdhTel2);
		}
		return verification;
	}

	//Va effectuer à tour de rôle chaque methode de test
	public boolean verificationFormulaire() {
		boolean verification;
		String messageErreur="ERREUR : Le formulaire n'est pas conforme !\n\n";
		
		verification=informationComplete();
		if (verification == true) {
			verification=tousDeBonneTaille();
		}else {
			messageErreur = messageErreur+" - Tout les chambres n'ont pas été bien saisis, modifier les champs en rouge\n";
		}
		
		if (verification == true) {
			verification=tousSontDesValeurEntiere();
		}else {
			messageErreur = messageErreur+" - Un ou plusieurs champs n'a pas une taille réglementaire\n";
		}
		
		if (verification == true) {
			verification=tousOnUneBonneEtendue();
		}else {
			messageErreur = messageErreur+" - Un ou plusieurs champs n'est pas une valeur entiere\n";
		}
		
		if (verification != true) {
			messageErreur = messageErreur+" - Un ou plusieurs champs est, soit trop grand, soit trop petit\n";
			JOptionPane.showMessageDialog(contentPane,messageErreur);
		}
		
		return verification;
	}
	
	//Hé vérifie que tous les champs qui doivent être remplis obligatoirement doivent être remplis 
	public boolean informationComplete() {
		formulaireComplete = true;
		for( Component comp : contentPane.getComponents()) {//comp sera a tour de role associer a chaque composent du formulaire
			if( comp instanceof JTextField) {//Si comp est un element JTextField (les zone de saisie de texte)
				if (LesTxtfASaisir.contains((JTextField)comp)) {
					JTextField UnChampDeText = (JTextField)comp;
					if (UnChampDeText.getText().equals("")){//Si les champ est vide
						//JOptionPane.showMessageDialog(UnChampDeText,"Il n'y a rien de saisi dans ce champ.");
						UnChampDeText.setBackground(Color.RED);//Change la couleur de l'arriere plan pour indiquer l'erreur
						UnChampDeText.addMouseListener(new MouseAdapter() {//Si on clique sur la zone de texte ciblé
							@Override
							public void mouseClicked(MouseEvent e) {
								UnChampDeText.setBackground(Color.WHITE);//Alors elle redivent blanche
							}
						});
						formulaireComplete = false;
					}
				}
			}
		}
		return formulaireComplete;
	}

	/**
	 * Create the frame.
	 */
	public JFformulaireAdherents() {
		addWindowListener(new WindowAdapter() {//S'exécute comment ferme la fenêtre
			@Override
			public void windowClosed(WindowEvent e) {
				formEstOuvert=false;
			}
		});
		setResizable(false);
		setTitle("Ajouter un adhérent");
		setDefaultCloseOperation(JFformulaireAdherents.DISPOSE_ON_CLOSE);//Supprime l'objet frame, mais maintient l'exécution de l'application.
		setBounds(100, 100, 627, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdhTitreForm = new JLabel("Ajouter un adhérent");
		lblAdhTitreForm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdhTitreForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdhTitreForm.setBounds(0, 10, 600, 38);
		contentPane.add(lblAdhTitreForm);
		
		txtfAdhNom = new JTextField();
		txtfAdhNom.setBounds(107, 90, 179, 25);
		contentPane.add(txtfAdhNom);
		txtfAdhNom.setColumns(10);
		
		JLabel lblAdhNom = new JLabel("Nom* :");
		lblAdhNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhNom.setBounds(10, 91, 91, 19);
		contentPane.add(lblAdhNom);
		
		JLabel lblAdhPrenom = new JLabel("Prenom* :");
		lblAdhPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhPrenom.setBounds(10, 127, 91, 19);
		contentPane.add(lblAdhPrenom);
		
		txtfAdhPrenom = new JTextField();
		txtfAdhPrenom.setColumns(10);
		txtfAdhPrenom.setBounds(107, 126, 179, 25);
		contentPane.add(txtfAdhPrenom);
		
		JLabel lblAdhGenre = new JLabel("Genre* :");
		lblAdhGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhGenre.setBounds(10, 194, 91, 19);
		contentPane.add(lblAdhGenre);
		
		JRadioButton rdbtnAdhGenreM = new JRadioButton("Masculin");
		rdbtnAdhGenreM.setSelected(true);
		bgrGenre.add(rdbtnAdhGenreM);
		rdbtnAdhGenreM.setBounds(107, 194, 82, 21);
		contentPane.add(rdbtnAdhGenreM);
		
		JRadioButton rdbtnAdhGenreF = new JRadioButton("Féminin");
		bgrGenre.add(rdbtnAdhGenreF);
		rdbtnAdhGenreF.setBounds(204, 195, 82, 21);
		contentPane.add(rdbtnAdhGenreF);
		
		txtfAdhNomNaiss = new JTextField();
		txtfAdhNomNaiss.setColumns(10);
		txtfAdhNomNaiss.setBounds(467, 90, 133, 25);
		contentPane.add(txtfAdhNomNaiss);
		
		JLabel lblAdhNomNaiss = new JLabel("Nom de naissance :");
		lblAdhNomNaiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhNomNaiss.setBounds(324, 91, 133, 19);
		contentPane.add(lblAdhNomNaiss);
		
		JLabel lblAdhDateNaissSlach1 = new JLabel("/");
		lblAdhDateNaissSlach1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhDateNaissSlach1.setBounds(494, 126, 12, 24);
		contentPane.add(lblAdhDateNaissSlach1);
		
		txtfAdhDateNaissJ = new JTextField();
		txtfAdhDateNaissJ.setColumns(10);
		txtfAdhDateNaissJ.setBounds(467, 125, 25, 25);
		contentPane.add(txtfAdhDateNaissJ);
		
		JLabel lblAdhDateNaiss = new JLabel("Date de naissance* :");
		lblAdhDateNaiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhDateNaiss.setBounds(324, 131, 138, 19);
		contentPane.add(lblAdhDateNaiss);
		
		txtfAdhDateNaissM = new JTextField();
		txtfAdhDateNaissM.setColumns(10);
		txtfAdhDateNaissM.setBounds(504, 125, 25, 25);
		contentPane.add(txtfAdhDateNaissM);
		
		txtfAdhDateNaissA = new JTextField();
		txtfAdhDateNaissA.setColumns(10);
		txtfAdhDateNaissA.setBounds(541, 125, 59, 25);
		contentPane.add(txtfAdhDateNaissA);
		
		JLabel lblAdhDateNaissSlach2 = new JLabel("/");
		lblAdhDateNaissSlach2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhDateNaissSlach2.setBounds(531, 126, 12, 24);
		contentPane.add(lblAdhDateNaissSlach2);
		
		JLabel lblAdhPaysNaiss = new JLabel("Pays de naissance* :");
		lblAdhPaysNaiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhPaysNaiss.setBounds(324, 168, 138, 19);
		contentPane.add(lblAdhPaysNaiss);
		
		JLabel lblAdhVilleNaiss = new JLabel("Ville de naissance* :");
		lblAdhVilleNaiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhVilleNaiss.setBounds(324, 197, 133, 19);
		contentPane.add(lblAdhVilleNaiss);
		
		txtfAdhPaysNaiss = new JTextField();
		txtfAdhPaysNaiss.setColumns(10);
		txtfAdhPaysNaiss.setBounds(467, 162, 133, 25);
		contentPane.add(txtfAdhPaysNaiss);
		
		txtfAdhVilleNaiss = new JTextField();
		txtfAdhVilleNaiss.setColumns(10);
		txtfAdhVilleNaiss.setBounds(467, 199, 133, 25);
		contentPane.add(txtfAdhVilleNaiss);
		
		JLabel lblAdhAdresse = new JLabel("Adresse* :");
		lblAdhAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhAdresse.setBounds(10, 270, 91, 19);
		contentPane.add(lblAdhAdresse);
		
		txtfAdhAdresse = new JTextField();
		txtfAdhAdresse.setColumns(10);
		txtfAdhAdresse.setBounds(107, 269, 493, 25);
		contentPane.add(txtfAdhAdresse);
		
		JLabel lblAdhCP = new JLabel("Code Postal* :");
		lblAdhCP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdhCP.setBounds(10, 240, 91, 19);
		contentPane.add(lblAdhCP);
		
		txtfAdhCP = new JTextField();
		txtfAdhCP.setColumns(10);
		txtfAdhCP.setBounds(107, 234, 68, 25);
		contentPane.add(txtfAdhCP);
		
		JLabel lblAdhVille = new JLabel("Ville* :");
		lblAdhVille.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhVille.setBounds(185, 235, 48, 19);
		contentPane.add(lblAdhVille);
		
		txtfAdhVille = new JTextField();
		txtfAdhVille.setColumns(10);
		txtfAdhVille.setBounds(232, 234, 368, 25);
		contentPane.add(txtfAdhVille);
		
		txtfAdhTel1 = new JTextField();
		txtfAdhTel1.setColumns(10);
		txtfAdhTel1.setBounds(107, 304, 187, 25);
		contentPane.add(txtfAdhTel1);
		
		JLabel lblAdhTel1 = new JLabel("Telephone 1* :");
		lblAdhTel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdhTel1.setBounds(10, 305, 99, 19);
		contentPane.add(lblAdhTel1);
		
		txtfAdhTel2 = new JTextField();
		txtfAdhTel2.setColumns(10);
		txtfAdhTel2.setBounds(413, 304, 187, 25);
		contentPane.add(txtfAdhTel2);
		
		JLabel lblAdhTel2 = new JLabel("Telephone 2 :");
		lblAdhTel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhTel2.setBounds(309, 305, 105, 19);
		contentPane.add(lblAdhTel2);
		
		JLabel lblAdhCourriel = new JLabel("Courriel* :");
		lblAdhCourriel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhCourriel.setBounds(10, 340, 91, 19);
		contentPane.add(lblAdhCourriel);
		
		txtfAdhCourriel = new JTextField();
		txtfAdhCourriel.setColumns(10);
		txtfAdhCourriel.setBounds(107, 339, 493, 25);
		contentPane.add(txtfAdhCourriel);
		
		JLabel lblAdhNomPrenomLeg = new JLabel("Nom et Prenom du responsable légal :");
		lblAdhNomPrenomLeg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhNomPrenomLeg.setBounds(10, 370, 295, 19);
		contentPane.add(lblAdhNomPrenomLeg);
		
		txtfAdhNomPrenomLeg = new JTextField();
		txtfAdhNomPrenomLeg.setColumns(10);
		txtfAdhNomPrenomLeg.setBounds(10, 399, 590, 25);
		contentPane.add(txtfAdhNomPrenomLeg);
		
		JLabel lblAdhArme = new JLabel("Arme* :");
		lblAdhArme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhArme.setBounds(10, 434, 91, 19);
		contentPane.add(lblAdhArme);
		
		JCheckBox rdbtnAdhArmeF = new JCheckBox("Fleuret");
		rdbtnAdhArmeF.setSelected(true);
		bgrArme.add(rdbtnAdhArmeF);
		rdbtnAdhArmeF.setBounds(107, 435, 93, 21);
		contentPane.add(rdbtnAdhArmeF);
		
		JCheckBox rdbtnAdhArmeE = new JCheckBox("Epee");
		bgrArme.add(rdbtnAdhArmeE);
		rdbtnAdhArmeE.setBounds(107, 458, 93, 21);
		contentPane.add(rdbtnAdhArmeE);
		
		JCheckBox rdbtnAdhArmeS = new JCheckBox("Sabre");
		bgrArme.add(rdbtnAdhArmeS);
		rdbtnAdhArmeS.setBounds(107, 481, 93, 21);
		contentPane.add(rdbtnAdhArmeS);
		
		JLabel lblAdhPratique = new JLabel("Pratique* :");
		lblAdhPratique.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhPratique.setBounds(261, 434, 91, 19);
		contentPane.add(lblAdhPratique);
		
		JLabel lblAdhLateralite = new JLabel("Latéralité* :");
		lblAdhLateralite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhLateralite.setBounds(261, 462, 91, 19);
		contentPane.add(lblAdhLateralite);
		
		JCheckBox rdbtnAdhPratiqueL = new JCheckBox("Loisir");
		rdbtnAdhPratiqueL.setSelected(true);
		bgrPratique.add(rdbtnAdhPratiqueL);
		rdbtnAdhPratiqueL.setBounds(358, 435, 93, 21);
		contentPane.add(rdbtnAdhPratiqueL);
		
		JCheckBox rdbtnAdhPratiqueC = new JCheckBox("Compétition");
		bgrPratique.add(rdbtnAdhPratiqueC);
		rdbtnAdhPratiqueC.setBounds(453, 435, 126, 21);
		contentPane.add(rdbtnAdhPratiqueC);
		
		JCheckBox rdbtnAdhLateraliteD = new JCheckBox("Droitier");
		rdbtnAdhLateraliteD.setSelected(true);
		bgrLateralite.add(rdbtnAdhLateraliteD);
		rdbtnAdhLateraliteD.setBounds(358, 463, 93, 21);
		contentPane.add(rdbtnAdhLateraliteD);
		
		JCheckBox rdbtnAdhLateraliteG = new JCheckBox("Gaucher");
		bgrLateralite.add(rdbtnAdhLateraliteG);
		rdbtnAdhLateraliteG.setBounds(453, 463, 126, 21);
		contentPane.add(rdbtnAdhLateraliteG);
		
		JLabel lblAdhFFE = new JLabel("|          Licence FFE :");
		lblAdhFFE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhFFE.setBounds(309, 371, 165, 19);
		contentPane.add(lblAdhFFE);
		
		JCheckBox rdbtnAdhFFEO = new JCheckBox("Oui");
		bgrFFE.add(rdbtnAdhFFEO);
		rdbtnAdhFFEO.setBounds(480, 372, 59, 21);
		contentPane.add(rdbtnAdhFFEO);
		
		JCheckBox rdbtnAdhFFEN = new JCheckBox("Non");
		bgrFFE.add(rdbtnAdhFFEN);
		rdbtnAdhFFEN.setBounds(541, 372, 59, 21);
		contentPane.add(rdbtnAdhFFEN);
		
		JLabel lblAdhAssurance = new JLabel("Assurance :");
		lblAdhAssurance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhAssurance.setBounds(988, 115, 91, 19);
		contentPane.add(lblAdhAssurance);
		
		JCheckBox rdbtnAdhAssurenceO = new JCheckBox("Oui");
		rdbtnAdhAssurenceO.setEnabled(false);
		bgrAssurence.add(rdbtnAdhAssurenceO);
		rdbtnAdhAssurenceO.setBounds(1085, 116, 59, 21);
		contentPane.add(rdbtnAdhAssurenceO);
		
		JCheckBox rdbtnAdhAssuranceN = new JCheckBox("Non");
		rdbtnAdhAssuranceN.setEnabled(false);
		bgrAssurence.add(rdbtnAdhAssuranceN);
		rdbtnAdhAssuranceN.setBounds(1146, 116, 59, 21);
		contentPane.add(rdbtnAdhAssuranceN);
		
		JLabel lblAdhReducFamille = new JLabel("Reduction famille :");
		lblAdhReducFamille.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhReducFamille.setBounds(988, 186, 133, 19);
		contentPane.add(lblAdhReducFamille);
		
		JCheckBox rdbtnAdhReducFO = new JCheckBox("Oui");
		rdbtnAdhReducFO.setEnabled(false);
		bgrReducFamille.add(rdbtnAdhReducFO);
		rdbtnAdhReducFO.setBounds(1144, 187, 59, 21);
		contentPane.add(rdbtnAdhReducFO);
		
		JCheckBox rdbtnAdhReducFN = new JCheckBox("Non");
		rdbtnAdhReducFN.setEnabled(false);
		bgrReducFamille.add(rdbtnAdhReducFN);
		rdbtnAdhReducFN.setBounds(1205, 187, 59, 21);
		contentPane.add(rdbtnAdhReducFN);
		
		JLabel lblAdhReducFText = new JLabel("Si oui vous est le");
		lblAdhReducFText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhReducFText.setBounds(988, 216, 127, 19);
		contentPane.add(lblAdhReducFText);
		
		JComboBox cmbAdhReducFamille = new JComboBox();
		cmbAdhReducFamille.setEnabled(false);
		cmbAdhReducFamille.setModel(new DefaultComboBoxModel(new String[] {"Rien", "2e adhérent", "3e adhérent ou plus"}));
		cmbAdhReducFamille.setBounds(1104, 217, 160, 21);
		contentPane.add(cmbAdhReducFamille);
		
		JLabel lblAdhSeancesTir = new JLabel("10 Seances pour tireurs : ");
		lblAdhSeancesTir.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdhSeancesTir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhSeancesTir.setBounds(674, 186, 212, 19);
		contentPane.add(lblAdhSeancesTir);
		
		JCheckBox rdbtnAdhSeanceTirO = new JCheckBox("Oui");
		rdbtnAdhSeanceTirO.setEnabled(false);
		bgrSeanceTir.add(rdbtnAdhSeanceTirO);
		rdbtnAdhSeanceTirO.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAdhSeanceTirO.setBounds(674, 211, 93, 21);
		contentPane.add(rdbtnAdhSeanceTirO);
		
		JCheckBox rdbtnAdhSeanceTirN = new JCheckBox("Non");
		rdbtnAdhSeanceTirN.setEnabled(false);
		bgrSeanceTir.add(rdbtnAdhSeanceTirN);
		rdbtnAdhSeanceTirN.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAdhSeanceTirN.setBounds(793, 211, 93, 21);
		contentPane.add(rdbtnAdhSeanceTirN);
		
		JComboBox cmbAdhCategorie = new JComboBox();
		cmbAdhCategorie.setModel(new DefaultComboBoxModel(new String[] {"Éveil", "Atomes", "Poussins", "Pupilles", "Benjamins", "Minimes", "Cadets", "Juniors", "Séniors", "Vétérans"}));
		cmbAdhCategorie.setBounds(348, 492, 179, 22);
		contentPane.add(cmbAdhCategorie);
		
		JLabel lblAdhAideMobil = new JLabel("Dispositif d'aide mobilisé");
		lblAdhAideMobil.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdhAideMobil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhAideMobil.setBounds(674, 300, 590, 25);
		contentPane.add(lblAdhAideMobil);
		
		JTextArea txtaAdhAideMobil = new JTextArea();
		txtaAdhAideMobil.setEnabled(false);
		txtaAdhAideMobil.setBounds(673, 329, 591, 173);
		contentPane.add(txtaAdhAideMobil);
		
		JButton btnAdhValider = new JButton("Valider");
		btnAdhValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//On effectué un test pour vérifier que les informations d'enfant lui reçoivent bon 
				if (verificationFormulaire()==true) {
					String Genre;
					String Arme="";
					String Pratique;
					String Lateralite;
					String Categorie=(String) cmbAdhCategorie.getSelectedItem();
					boolean FFE;
					
					//On détermine le résultat des boutons sélectionnés 
					if (rdbtnAdhGenreM.isSelected()) {
						Genre = "Masculin";
					}else {
						Genre = "Féminin";
					}
					
					if (rdbtnAdhArmeF.isSelected()) {
						Arme = "Fleuret";
					}
					if (rdbtnAdhArmeE.isSelected()) {
						Arme = "Epee";
					}
					if (rdbtnAdhArmeS.isSelected()) {
						Arme = "Sabre";
					}

					if (rdbtnAdhPratiqueL.isSelected()) {
						Pratique = "Loisir";
					}else {
						Pratique = "Compétition";
					}
					
					if (rdbtnAdhLateraliteD.isSelected()) {
						Lateralite = "Droitier";
					}else {
						Lateralite = "Gaucher";
					}
					
					if (rdbtnAdhFFEO.isSelected()) {
						FFE = true;
					}else {
						FFE = false;
					}
					
					//Création de l'adhérent à partir du formulaire 
					//NE PAS SUPPRIMER version finale de l'instanciaition de adhérent
					Adherent adh = new Adherent(
							txtfAdhNom.getText(),
							txtfAdhNomNaiss.getText(),
							txtfAdhPrenom.getText(),
							txtfAdhDateNaissJ.getText()+"/"
							+txtfAdhDateNaissM.getText()+"/"
							+txtfAdhDateNaissA.getText(),
							txtfAdhNationalite.getText(),
							txtfAdhPaysNaiss.getText(),
							Genre,
							txtfAdhVilleNaiss.getText(),
							Integer.valueOf(txtfAdhCP.getText()),
							txtfAdhVille.getText(),
							txtfAdhAdresse.getText(),
							Integer.valueOf(txtfAdhTel1.getText()),
							Integer.valueOf(txtfAdhTel2.getText()),
							txtfAdhCourriel.getText(),
							txtfAdhNomPrenomLeg.getText(),
							Arme,
							Pratique,
							Lateralite,
							Categorie,
							FFE,
							false,
							false,
							false,
							1,
							"");
					
					//Adherent test, a supprimer
					/*Adherent adh2 = new Adherent(
							//1,
							"Avdvdf",
							"bories",
							"bastien",
							"29/01/2002",
							"francais",
							"Fradddddnce",
							Genre,
							"Castres",
							31400,
							"Toulouse",
							"118 Rte de Narbonne",
							781818181,
							781818181,
							"b0728382@gmail.com",
							"",
							Arme,
							Pratique,
							Lateralite,
							Categorie,
							false,
							false,
							false,
							false,
							1,
							"tst");*/
					JOptionPane.showMessageDialog(contentPane,"Les information sont valide");
					/*try {
						JOptionPane.showMessageDialog(contentPane,lectureXML.importationXMLadherent().size());
					} catch (HeadlessException | ParserConfigurationException | SAXException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}*/
					//Écriture de l'adhérent dans le fichier XML
					try {
						ecritureXML.newAdherant(adh);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					/*try {
						System.out.println(lectureXML.importationXMLadherent().size());
						System.out.println(lectureXML.importationXMLadherent().get(3).getNom());
					} catch (ParserConfigurationException | SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
				}
			}
		});
		btnAdhValider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdhValider.setBounds(112, 583, 160, 38);
		contentPane.add(btnAdhValider);
		
		JButton btnReinitialiser = new JButton("Réinitialiser");
		btnReinitialiser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for( Component comp : contentPane.getComponents()) {/*comp sera a tour de role associer a chaque composent du formulaire*/
					if( comp instanceof JTextField) {/*Si comp est un element JTextField (les zone de saisie de texte)*/
						((JTextField)comp).setText(null);/*Definit le JtextField equivalent a comp, comme null*/
						((JTextField)comp).setBackground(Color.WHITE);
					}
					if(comp instanceof JTextArea) {
						((JTextArea)comp).setText(null);
					}
				}
			}
		});
		btnReinitialiser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReinitialiser.setBounds(346, 583, 160, 38);
		contentPane.add(btnReinitialiser);
		
		JLabel lblCategorie = new JLabel("Categorie* :");
		lblCategorie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategorie.setBounds(261, 492, 77, 19);
		contentPane.add(lblCategorie);
		
		JLabel lblAdhNom_1 = new JLabel("INFORMATION : Les éléments contenant un * doit être complété pour valider le formulaire.");
		lblAdhNom_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdhNom_1.setBounds(10, 545, 590, 19);
		contentPane.add(lblAdhNom_1);
		
		JLabel lblAdhNationalite = new JLabel("Nationalité* :");
		lblAdhNationalite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhNationalite.setBounds(10, 164, 91, 19);
		contentPane.add(lblAdhNationalite);
		
		txtfAdhNationalite = new JTextField();
		txtfAdhNationalite.setColumns(10);
		txtfAdhNationalite.setBounds(107, 163, 179, 25);
		contentPane.add(txtfAdhNationalite);
		
		init();
	}
}
