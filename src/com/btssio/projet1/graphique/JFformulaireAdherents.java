package com.btssio.projet1.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;

public class JFformulaireAdherents extends JFrame {

	private JPanel contentPane;
	private JTextField txtfAdhNom;
	private JTextField txtfAdhPrenom;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();

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

	/**
	 * Create the frame.
	 */
	public JFformulaireAdherents() {
		setResizable(false);
		setTitle("Ajouter un adhérent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1291, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdhTitreForm = new JLabel("Ajouter un adhérent");
		lblAdhTitreForm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdhTitreForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdhTitreForm.setBounds(0, 10, 1287, 38);
		contentPane.add(lblAdhTitreForm);
		
		txtfAdhNom = new JTextField();
		txtfAdhNom.setBounds(107, 90, 179, 25);
		contentPane.add(txtfAdhNom);
		txtfAdhNom.setColumns(10);
		
		JLabel lblAdhNom = new JLabel("Nom");
		lblAdhNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhNom.setBounds(10, 91, 91, 19);
		contentPane.add(lblAdhNom);
		
		JLabel lblAdhPrenom = new JLabel("Prenom :");
		lblAdhPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhPrenom.setBounds(10, 127, 91, 19);
		contentPane.add(lblAdhPrenom);
		
		txtfAdhPrenom = new JTextField();
		txtfAdhPrenom.setColumns(10);
		txtfAdhPrenom.setBounds(107, 126, 179, 25);
		contentPane.add(txtfAdhPrenom);
		
		JLabel lblAdhGenre = new JLabel("Genre :");
		lblAdhGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhGenre.setBounds(10, 168, 91, 19);
		contentPane.add(lblAdhGenre);
		
		JRadioButton rdbtnAdhGenreM = new JRadioButton("Masculin");
		buttonGroup.add(rdbtnAdhGenreM);
		rdbtnAdhGenreM.setBounds(107, 168, 179, 21);
		contentPane.add(rdbtnAdhGenreM);
		
		JRadioButton rdbtnAdhGenreF = new JRadioButton("Féminin");
		buttonGroup.add(rdbtnAdhGenreF);
		rdbtnAdhGenreF.setBounds(107, 198, 179, 21);
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
		
		JLabel lblAdhDateNaiss = new JLabel("Date de naissance :");
		lblAdhDateNaiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhDateNaiss.setBounds(324, 131, 133, 19);
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
		
		JLabel lblAdhPaysNaiss = new JLabel("Pays de naissance :");
		lblAdhPaysNaiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhPaysNaiss.setBounds(324, 168, 133, 19);
		contentPane.add(lblAdhPaysNaiss);
		
		JLabel lblAdhVilleNaiss = new JLabel("Ville de naissance :");
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
		
		JLabel lblAdhAdresse = new JLabel("Adresse :");
		lblAdhAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhAdresse.setBounds(10, 270, 91, 19);
		contentPane.add(lblAdhAdresse);
		
		txtfAdhAdresse = new JTextField();
		txtfAdhAdresse.setColumns(10);
		txtfAdhAdresse.setBounds(107, 269, 493, 25);
		contentPane.add(txtfAdhAdresse);
		
		JLabel lblAdhCP = new JLabel("Code Postal :");
		lblAdhCP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhCP.setBounds(10, 240, 91, 19);
		contentPane.add(lblAdhCP);
		
		txtfAdhCP = new JTextField();
		txtfAdhCP.setColumns(10);
		txtfAdhCP.setBounds(107, 234, 68, 25);
		contentPane.add(txtfAdhCP);
		
		JLabel lblAdhVille = new JLabel("Ville :");
		lblAdhVille.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhVille.setBounds(185, 235, 37, 19);
		contentPane.add(lblAdhVille);
		
		txtfAdhVille = new JTextField();
		txtfAdhVille.setColumns(10);
		txtfAdhVille.setBounds(232, 234, 368, 25);
		contentPane.add(txtfAdhVille);
		
		txtfAdhTel1 = new JTextField();
		txtfAdhTel1.setColumns(10);
		txtfAdhTel1.setBounds(107, 304, 187, 25);
		contentPane.add(txtfAdhTel1);
		
		JLabel lblAdhTel1 = new JLabel("Telephone 1 :");
		lblAdhTel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhTel1.setBounds(10, 305, 94, 19);
		contentPane.add(lblAdhTel1);
		
		txtfAdhTel2 = new JTextField();
		txtfAdhTel2.setColumns(10);
		txtfAdhTel2.setBounds(413, 304, 187, 25);
		contentPane.add(txtfAdhTel2);
		
		JLabel lblAdhTel2 = new JLabel("Telephone 2 :");
		lblAdhTel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhTel2.setBounds(309, 305, 94, 19);
		contentPane.add(lblAdhTel2);
		
		JLabel lblAdhCourriel = new JLabel("Courriel :");
		lblAdhCourriel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhCourriel.setBounds(10, 340, 91, 19);
		contentPane.add(lblAdhCourriel);
		
		txtfAdhCourriel = new JTextField();
		txtfAdhCourriel.setColumns(10);
		txtfAdhCourriel.setBounds(107, 339, 493, 25);
		contentPane.add(txtfAdhCourriel);
		
		JLabel lblAdhNomPrenomLeg = new JLabel("Nom et Prenom du responsable légal :");
		lblAdhNomPrenomLeg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhNomPrenomLeg.setBounds(10, 370, 590, 19);
		contentPane.add(lblAdhNomPrenomLeg);
		
		txtfAdhNomPrenomLeg = new JTextField();
		txtfAdhNomPrenomLeg.setColumns(10);
		txtfAdhNomPrenomLeg.setBounds(10, 399, 590, 25);
		contentPane.add(txtfAdhNomPrenomLeg);
		
		JLabel lblAdhArme = new JLabel("Arme :");
		lblAdhArme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhArme.setBounds(10, 434, 91, 19);
		contentPane.add(lblAdhArme);
		
		JCheckBox rdbtnAdhArmeF = new JCheckBox("Fleuret");
		buttonGroup_1.add(rdbtnAdhArmeF);
		rdbtnAdhArmeF.setBounds(107, 435, 93, 21);
		contentPane.add(rdbtnAdhArmeF);
		
		JCheckBox rdbtnAdhArmeE = new JCheckBox("Epee");
		buttonGroup_1.add(rdbtnAdhArmeE);
		rdbtnAdhArmeE.setBounds(107, 458, 93, 21);
		contentPane.add(rdbtnAdhArmeE);
		
		JCheckBox rdbtnAdhArmeS = new JCheckBox("Sabre");
		buttonGroup_1.add(rdbtnAdhArmeS);
		rdbtnAdhArmeS.setBounds(107, 481, 93, 21);
		contentPane.add(rdbtnAdhArmeS);
		
		JLabel lblAdhPratique = new JLabel("Pratique :");
		lblAdhPratique.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhPratique.setBounds(261, 434, 91, 19);
		contentPane.add(lblAdhPratique);
		
		JLabel lblAdhLateralite = new JLabel("Latéralité :");
		lblAdhLateralite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhLateralite.setBounds(261, 462, 91, 19);
		contentPane.add(lblAdhLateralite);
		
		JCheckBox rdbtnAdhPratiqueL = new JCheckBox("Loisir");
		buttonGroup.add(rdbtnAdhPratiqueL);
		rdbtnAdhPratiqueL.setBounds(358, 435, 93, 21);
		contentPane.add(rdbtnAdhPratiqueL);
		
		JCheckBox rdbtnAdhPratiqueC = new JCheckBox("Compétition");
		buttonGroup.add(rdbtnAdhPratiqueC);
		rdbtnAdhPratiqueC.setBounds(453, 435, 126, 21);
		contentPane.add(rdbtnAdhPratiqueC);
		
		JCheckBox rdbtnAdhLateraliteD = new JCheckBox("Droitier");
		buttonGroup_2.add(rdbtnAdhLateraliteD);
		rdbtnAdhLateraliteD.setBounds(358, 463, 93, 21);
		contentPane.add(rdbtnAdhLateraliteD);
		
		JCheckBox rdbtnAdhLateraliteG = new JCheckBox("Gaucher");
		buttonGroup_2.add(rdbtnAdhLateraliteG);
		rdbtnAdhLateraliteG.setBounds(453, 463, 126, 21);
		contentPane.add(rdbtnAdhLateraliteG);
		
		JLabel lblAdhFFE = new JLabel("Licence FFE :");
		lblAdhFFE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhFFE.setBounds(674, 90, 91, 19);
		contentPane.add(lblAdhFFE);
		
		JCheckBox rdbtnAdhFFEO = new JCheckBox("Oui");
		buttonGroup_3.add(rdbtnAdhFFEO);
		rdbtnAdhFFEO.setBounds(771, 91, 59, 21);
		contentPane.add(rdbtnAdhFFEO);
		
		JCheckBox rdbtnAdhFFEN = new JCheckBox("Non");
		buttonGroup_3.add(rdbtnAdhFFEN);
		rdbtnAdhFFEN.setBounds(832, 91, 59, 21);
		contentPane.add(rdbtnAdhFFEN);
		
		JLabel lblAdhAssurance = new JLabel("Assurance :");
		lblAdhAssurance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhAssurance.setBounds(674, 115, 91, 19);
		contentPane.add(lblAdhAssurance);
		
		JCheckBox rdbtnAdhAssurenceO = new JCheckBox("Oui");
		buttonGroup_4.add(rdbtnAdhAssurenceO);
		rdbtnAdhAssurenceO.setBounds(771, 116, 59, 21);
		contentPane.add(rdbtnAdhAssurenceO);
		
		JCheckBox rdbtnAdhAssuranceN = new JCheckBox("Non");
		buttonGroup_4.add(rdbtnAdhAssuranceN);
		rdbtnAdhAssuranceN.setBounds(832, 116, 59, 21);
		contentPane.add(rdbtnAdhAssuranceN);
		
		JLabel lblAdhReducFamille = new JLabel("Reduction famille :");
		lblAdhReducFamille.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhReducFamille.setBounds(988, 90, 133, 19);
		contentPane.add(lblAdhReducFamille);
		
		JCheckBox rdbtnAdhReducFO = new JCheckBox("Oui");
		buttonGroup_5.add(rdbtnAdhReducFO);
		rdbtnAdhReducFO.setBounds(1144, 91, 59, 21);
		contentPane.add(rdbtnAdhReducFO);
		
		JCheckBox rdbtnAdhReducFN = new JCheckBox("Non");
		buttonGroup_5.add(rdbtnAdhReducFN);
		rdbtnAdhReducFN.setBounds(1205, 91, 59, 21);
		contentPane.add(rdbtnAdhReducFN);
		
		JLabel lblAdhReducFText = new JLabel("Si oui vous est le");
		lblAdhReducFText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhReducFText.setBounds(988, 120, 127, 19);
		contentPane.add(lblAdhReducFText);
		
		JComboBox cmbAdhReducFamille = new JComboBox();
		cmbAdhReducFamille.setModel(new DefaultComboBoxModel(new String[] {"2e adhérent", "3e adhérent ou plus"}));
		cmbAdhReducFamille.setBounds(1104, 121, 160, 21);
		contentPane.add(cmbAdhReducFamille);
		
		JLabel lblAdhSeancesTir = new JLabel("10 Seances pour tireurs : ");
		lblAdhSeancesTir.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdhSeancesTir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhSeancesTir.setBounds(853, 198, 212, 19);
		contentPane.add(lblAdhSeancesTir);
		
		JCheckBox rdbtnAdhSeanceTirO = new JCheckBox("Oui");
		buttonGroup_6.add(rdbtnAdhSeanceTirO);
		rdbtnAdhSeanceTirO.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAdhSeanceTirO.setBounds(853, 223, 93, 21);
		contentPane.add(rdbtnAdhSeanceTirO);
		
		JCheckBox rdbtnAdhSeanceTirN = new JCheckBox("Non");
		buttonGroup_6.add(rdbtnAdhSeanceTirN);
		rdbtnAdhSeanceTirN.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAdhSeanceTirN.setBounds(972, 223, 93, 21);
		contentPane.add(rdbtnAdhSeanceTirN);
		
		JLabel lblAdhAideMobil = new JLabel("Dispositif d'aide mobilisé");
		lblAdhAideMobil.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdhAideMobil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdhAideMobil.setBounds(674, 300, 590, 25);
		contentPane.add(lblAdhAideMobil);
		
		JTextArea txtaAdhAideMobil = new JTextArea();
		txtaAdhAideMobil.setBounds(673, 329, 591, 173);
		contentPane.add(txtaAdhAideMobil);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(440, 568, 160, 38);
		contentPane.add(btnNewButton);
		
		JButton btnRinitialiser = new JButton("Réinitialiser");
		btnRinitialiser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRinitialiser.setBounds(674, 568, 160, 38);
		contentPane.add(btnRinitialiser);
	}
}
