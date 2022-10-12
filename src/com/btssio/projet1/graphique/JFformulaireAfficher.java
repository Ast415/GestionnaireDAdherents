package com.btssio.projet1.graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.btssio.projet1.classe.Adherent;

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
import javax.swing.SwingConstants;

public class JFformulaireAfficher extends JFrame {

	private JPanel contentPane;
	private JTextField txtfAffIDAdh;
	private JTextPane txtpAffResultat;
	protected static boolean formEstOuvert = false;//Variable permettant de déterminer si la fenêtre est ouverte ou non 
	//Ha adhérent de test 
	private Adherent testAdh1 = new Adherent(
			//2,
			"duval",
			"duval",
			"edourd",
			"10/02/1997",
			"francais",
			"France",
			"homme",
			"Castres",
			57130,
			"Sainte-Ruffine",
			"26 Rue du Gros Chine",
			781818181,
			781818181,
			"b0728382@gmail.com",
			"",
			"Fleuret",
			"Loisir",
			"Droitier",
			"Eveil",
			false,
			false,
			false,
			false,
			1,
			"edcdccdcdc");
	private Adherent testAdh2 = new Adherent(
			//3,
			"Ren",
			"Ren",
			"Allard",
			"20/11/1983",
			"francais",
			"France",
			"homme",
			"Castres",
			14330,
			"Tournires",
			"27 Rue du Moulin Cass",
			781818181,
			781818181,
			"b0728382@gmail.com",
			"",
			"Epee",
			"Compétitive",
			"Gaucher",
			"Minimes",
			false,
			false,
			false,
			false,
			1,
			"edcdccdcdc");
	//Hé liste des adhérents de test 
	private ArrayList<Adherent> lesTestAdherent = new ArrayList<Adherent>();
	
	public void init() {
		lesTestAdherent.add(testAdh1);
		lesTestAdherent.add(testAdh2);
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
				//Hé on va récupérer la valeur qu'il y a dans le champ 
				int idAdherent = Integer.valueOf(txtfAffIDAdh.getText());
				//Si cette valeur est une entité dans la liste des adhérents alors on affiche ces informations
				//Hé dans la liste adhérent la position de l'adhérent est son identifiant sont la même chose 
				if (idAdherent<lesTestAdherent.size() && idAdherent>=0) {
					txtpAffResultat.setForeground(new Color(0, 0, 0));//Mets la couleur du texte en noir 
					txtpAffResultat.setText(
							  "Nom : "+lesTestAdherent.get(idAdherent).getNom()
							+ "\nPrenom : "+lesTestAdherent.get(idAdherent).getPrenom()
							+ "\nDate de naissance : "+lesTestAdherent.get(idAdherent).getDateDeNaissance()
							+ "\nGenre : "+lesTestAdherent.get(idAdherent).getGenre()
							+ "\nVille : "+lesTestAdherent.get(idAdherent).getVille()
							+ "\nCode postal : "+lesTestAdherent.get(idAdherent).getCp()
							+ "\nAdresse : "+lesTestAdherent.get(idAdherent).getAdresse()
							+ "\nNuméro de téléphone 1 : 0"+lesTestAdherent.get(idAdherent).getNumeroDeTelephone1()
							+ "\nNuméro de téléphone 2 : 0"+lesTestAdherent.get(idAdherent).getNumeroDeTelephone2()
							+ "\nCourriel : "+lesTestAdherent.get(idAdherent).getCourriel()
							+ "\nArme : "+lesTestAdherent.get(idAdherent).getArme()
							+ "\nPratique : "+lesTestAdherent.get(idAdherent).getPratique()
							+ "\nLatéralité : "+lesTestAdherent.get(idAdherent).getLateralité()
							+ "\nCatégotrie : "+lesTestAdherent.get(idAdherent).getCategorie());
				}else {
					txtpAffResultat.setForeground(new Color(213, 26, 0));//Hé mets la couleur du texte en rouge 
					txtpAffResultat.setText("Cet identifiant n'est pas reconnu, veuillez essayer un autre identifiant ");
				}
			}
		});
		btnAffValider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAffValider.setBounds(261, 507, 160, 38);
		contentPane.add(btnAffValider);
		
		txtfAffIDAdh = new JTextField();
		txtfAffIDAdh.setBounds(10, 151, 282, 27);
		contentPane.add(txtfAffIDAdh);
		txtfAffIDAdh.setColumns(10);
		
		JLabel lblAffIDAdh = new JLabel("Saisir l'identifiant d'un adhérent");
		lblAffIDAdh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAffIDAdh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAffIDAdh.setBounds(10, 102, 282, 38);
		contentPane.add(lblAffIDAdh);
		
		JLabel lblAfficherUnAdhrent = new JLabel("Afficher un adhérent");
		lblAfficherUnAdhrent.setToolTipText("Afficher un adhérent");
		lblAfficherUnAdhrent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfficherUnAdhrent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAfficherUnAdhrent.setBounds(10, 11, 725, 38);
		contentPane.add(lblAfficherUnAdhrent);
		
		txtpAffResultat = new JTextPane();
		txtpAffResultat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpAffResultat.setEditable(false);
		txtpAffResultat.setBounds(339, 113, 396, 340);
		contentPane.add(txtpAffResultat);
		init();
	}
}
