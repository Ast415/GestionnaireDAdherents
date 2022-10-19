package com.btssio.projet1.graphique;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.btssio.projet1.classe.Adherent;
import com.btssio.projet1.classe.categorie;
import com.btssio.projet1.classe.lectureXML;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JFformulaireCalcule extends JFrame {

	protected static boolean formEstOuvert = false;
	private JPanel contentPane;
	private ArrayList<Adherent> lesAdherent = new ArrayList<Adherent>();
	private ArrayList<categorie> lesCategorie = new ArrayList<categorie>();
	private JTextField txtfStatEveil;
	private JTextField txtfStatAto;
	private JTextField txtfStatPup;
	private JTextField txtfStatPous;
	private JTextField txtfStatJun;
	private JTextField txtfStatCad;
	private JTextField txtfStatMini;
	private JTextField txtfStatBen;
	private JTextField txtfStatSen;
	private JTextField txtfStatTotal;
	private JTextField txtfStatVet;
	private JLabel lblVtrans;
	
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
	
	public int montentCathegorieParAdh(String nomCathegorie) {
		int Somme = 0;
		for (int i=1;i<lesAdherent.size();i++) {
			if (lesAdherent.get(i).getCategorie().equals(nomCathegorie)) {
				Somme = Somme + lesAdherent.get(i).calculPrix();
			}
		}
		return Somme;
	}
	
	public int populationParCathegorie(String nomCathegorie) {
		int Somme = 0;
		for (int i=1;i<lesAdherent.size();i++) {
			if (lesAdherent.get(i).getCategorie().equals(nomCathegorie)) {
				Somme++;
			}
		}
		return Somme;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFformulaireCalcule frame = new JFformulaireCalcule();
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
	public JFformulaireCalcule() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFformulaireCalcule.class.getResource("/img/logoM1Icon.png")));
		setTitle("Menu statistique");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				formEstOuvert=false;
			}
			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtfStatEveil = new JTextField();
		txtfStatEveil.setEditable(false);
		txtfStatEveil.setBounds(32, 131, 106, 20);
		txtfStatEveil.setColumns(10);
		contentPane.add(txtfStatEveil);
		
		JLabel lblEveil = new JLabel("Éveil");
		lblEveil.setBounds(32, 101, 106, 19);
		lblEveil.setHorizontalAlignment(SwingConstants.CENTER);
		lblEveil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblEveil);
		
		txtfStatAto = new JTextField();
		txtfStatAto.setEditable(false);
		txtfStatAto.setColumns(10);
		txtfStatAto.setBounds(32, 192, 106, 20);
		contentPane.add(txtfStatAto);
		
		JLabel lblAtomes = new JLabel("Atomes");
		lblAtomes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtomes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAtomes.setBounds(32, 162, 106, 19);
		contentPane.add(lblAtomes);
		
		txtfStatPup = new JTextField();
		txtfStatPup.setEditable(false);
		txtfStatPup.setColumns(10);
		txtfStatPup.setBounds(148, 131, 106, 20);
		contentPane.add(txtfStatPup);
		
		JLabel lblPupilles = new JLabel("Pupilles");
		lblPupilles.setHorizontalAlignment(SwingConstants.CENTER);
		lblPupilles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPupilles.setBounds(148, 101, 106, 19);
		contentPane.add(lblPupilles);
		
		txtfStatPous = new JTextField();
		txtfStatPous.setEditable(false);
		txtfStatPous.setColumns(10);
		txtfStatPous.setBounds(32, 253, 106, 20);
		contentPane.add(txtfStatPous);
		
		JLabel lblPoussins = new JLabel("Poussins");
		lblPoussins.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoussins.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPoussins.setBounds(32, 223, 106, 19);
		contentPane.add(lblPoussins);
		
		txtfStatJun = new JTextField();
		txtfStatJun.setEditable(false);
		txtfStatJun.setColumns(10);
		txtfStatJun.setBounds(264, 192, 106, 20);
		contentPane.add(txtfStatJun);
		
		JLabel lblJuniors = new JLabel("Juniors");
		lblJuniors.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuniors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJuniors.setBounds(264, 162, 106, 19);
		contentPane.add(lblJuniors);
		
		txtfStatCad = new JTextField();
		txtfStatCad.setEditable(false);
		txtfStatCad.setColumns(10);
		txtfStatCad.setBounds(264, 131, 106, 20);
		contentPane.add(txtfStatCad);
		
		JLabel lblCadets = new JLabel("Cadets");
		lblCadets.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadets.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadets.setBounds(264, 101, 106, 19);
		contentPane.add(lblCadets);
		
		txtfStatMini = new JTextField();
		txtfStatMini.setEditable(false);
		txtfStatMini.setColumns(10);
		txtfStatMini.setBounds(148, 253, 106, 20);
		contentPane.add(txtfStatMini);
		
		JLabel lblMinimes = new JLabel("Minimes");
		lblMinimes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMinimes.setBounds(148, 223, 106, 19);
		contentPane.add(lblMinimes);
		
		txtfStatBen = new JTextField();
		txtfStatBen.setEditable(false);
		txtfStatBen.setColumns(10);
		txtfStatBen.setBounds(148, 192, 106, 20);
		contentPane.add(txtfStatBen);
		
		JLabel lblBenjamins = new JLabel("Benjamins");
		lblBenjamins.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenjamins.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBenjamins.setBounds(148, 162, 106, 19);
		contentPane.add(lblBenjamins);
		
		JLabel lblSeniores = new JLabel("Seniores");
		lblSeniores.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeniores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeniores.setBounds(264, 223, 106, 19);
		contentPane.add(lblSeniores);
		
		txtfStatSen = new JTextField();
		txtfStatSen.setEditable(false);
		txtfStatSen.setColumns(10);
		txtfStatSen.setBounds(264, 253, 106, 20);
		contentPane.add(txtfStatSen);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(148, 284, 222, 19);
		contentPane.add(lblTotal);
		
		txtfStatTotal = new JTextField();
		txtfStatTotal.setEditable(false);
		txtfStatTotal.setColumns(10);
		txtfStatTotal.setBounds(148, 314, 222, 20);
		contentPane.add(txtfStatTotal);
		
		JLabel lblMenuStatistique = new JLabel("Menu statistique");
		lblMenuStatistique.setToolTipText("Afficher un adhérent");
		lblMenuStatistique.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuStatistique.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenuStatistique.setBounds(32, 29, 338, 38);
		contentPane.add(lblMenuStatistique);
		
		txtfStatVet = new JTextField();
		txtfStatVet.setEditable(false);
		txtfStatVet.setColumns(10);
		txtfStatVet.setBounds(32, 314, 106, 20);
		contentPane.add(txtfStatVet);
		
		lblVtrans = new JLabel("Vétérans");
		lblVtrans.setHorizontalAlignment(SwingConstants.CENTER);
		lblVtrans.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVtrans.setBounds(32, 284, 106, 19);
		contentPane.add(lblVtrans);
		
		JButton btnStatVueMontent = new JButton("Montent");
		btnStatVueMontent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfStatEveil.setText(String.valueOf(montentCathegorieParAdh("Éveil")));
				txtfStatAto.setText(String.valueOf(montentCathegorieParAdh("Atomes")));
				txtfStatPous.setText(String.valueOf(montentCathegorieParAdh("Poussins")));
				txtfStatPup.setText(String.valueOf(montentCathegorieParAdh("Pupilles")));
				txtfStatBen.setText(String.valueOf(montentCathegorieParAdh("Benjamins")));
				txtfStatMini.setText(String.valueOf(montentCathegorieParAdh("Minimes")));
				txtfStatCad.setText(String.valueOf(montentCathegorieParAdh("Cadets")));
				txtfStatJun.setText(String.valueOf(montentCathegorieParAdh("Juniors")));
				txtfStatSen.setText(String.valueOf(montentCathegorieParAdh("Séniors")));
				txtfStatVet.setText(String.valueOf(montentCathegorieParAdh("Vétérans")));
				txtfStatTotal.setText("0");
				
				for( Component comp : contentPane.getComponents()) {
					if( comp instanceof JTextField) {
						int valTotal = Integer.parseInt(txtfStatTotal.getText());
						int valComp = Integer.parseInt(((JTextField)comp).getText());
						if(comp!=txtfStatTotal) {
							txtfStatTotal.setText(String.valueOf(valTotal+valComp));
						}
					}
				}
			}
		});
		btnStatVueMontent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStatVueMontent.setBounds(32, 358, 106, 27);
		contentPane.add(btnStatVueMontent);
		
		JButton btnStatVuePopulation = new JButton("Population");
		btnStatVuePopulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfStatEveil.setText(String.valueOf(populationParCathegorie("Éveil")));
				txtfStatAto.setText(String.valueOf(populationParCathegorie("Atomes")));
				txtfStatPous.setText(String.valueOf(populationParCathegorie("Poussins")));
				txtfStatPup.setText(String.valueOf(populationParCathegorie("Pupilles")));
				txtfStatBen.setText(String.valueOf(populationParCathegorie("Benjamins")));
				txtfStatMini.setText(String.valueOf(populationParCathegorie("Minimes")));
				txtfStatCad.setText(String.valueOf(populationParCathegorie("Cadets")));
				txtfStatJun.setText(String.valueOf(populationParCathegorie("Juniors")));
				txtfStatSen.setText(String.valueOf(populationParCathegorie("Séniors")));
				txtfStatVet.setText(String.valueOf(populationParCathegorie("Vétérans")));
				txtfStatTotal.setText("0");
				
				for( Component comp : contentPane.getComponents()) {
					if( comp instanceof JTextField) {
						int valTotal = Integer.parseInt(txtfStatTotal.getText());
						int valComp = Integer.parseInt(((JTextField)comp).getText());
						if(comp!=txtfStatTotal) {
							txtfStatTotal.setText(String.valueOf(valTotal+valComp));
						}
					}
				}
			}
		});
		btnStatVuePopulation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStatVuePopulation.setBounds(264, 358, 106, 27);
		contentPane.add(btnStatVuePopulation);
		
		init();
	}
}
