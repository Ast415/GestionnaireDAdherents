package com.btssio.projet1.graphique;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.btssio.projet1.classe.Adherent;
import com.btssio.projet1.classe.Club;
import com.btssio.projet1.classe.lectureXML;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JFformulaireAfficheClub extends JFrame {

	protected static boolean formEstOuvert = false;
	private JPanel contentPane;
	int id = 2;
	private ArrayList<Club> lesClub = new ArrayList<Club>();
	private JTextField nameJtext;
	private JTextField adresseJtext;
	private JTextField contactJtext;
	private JTextField telJtext;
	private JTextField mailJtext;
	private JTextField siteJtext;
	
	
	public void init() {
		
		try {
			//Importe les adherent du fichier xml et les place dans la liste lesAdherent
			lesClub=lectureXML.importationXMLClub();
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFformulaireAfficheClub frame = new JFformulaireAfficheClub();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void miseAjour() {
		nameJtext.setText(lesClub.get(id).getNom());
		adresseJtext.setText(lesClub.get(id).getAdresse());
		contactJtext.setText(lesClub.get(id).getContact());
		telJtext.setText(lesClub.get(id).getTel());
		mailJtext.setText(lesClub.get(id).getMail());
		siteJtext.setText(lesClub.get(id).getSite());
		
	}
	
	/**
	 * Create the frame.
	 */
	public JFformulaireAfficheClub() {
		
		init();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				formEstOuvert=false;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nom = new JLabel("Nom :");
		nom.setBounds(10, 11, 86, 14);
		contentPane.add(nom);
		
		JLabel adresse = new JLabel("adresse :");
		adresse.setBounds(10, 36, 86, 14);
		contentPane.add(adresse);
		
		JLabel contact = new JLabel("contact :");
		contact.setBounds(10, 61, 86, 14);
		contentPane.add(contact);
		
		JLabel telephone = new JLabel("n° de Telephone :");
		telephone.setBounds(10, 86, 86, 14);
		contentPane.add(telephone);
		
		JLabel mail = new JLabel("@ mail :");
		mail.setBounds(10, 111, 86, 14);
		contentPane.add(mail);
		
		JLabel siteWeb = new JLabel("site web :");
		siteWeb.setBounds(10, 136, 86, 14);
		contentPane.add(siteWeb);
		
		JButton btnNewButton = new JButton("precedent");
		btnNewButton.setBounds(10, 161, 98, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id > 0) {
					id = id - 1;
				}
				miseAjour();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("suivan");
		btnNewButton_1.setBounds(220, 161, 86, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id < lesClub.size()-1) {
					id = id + 1;
				}
				miseAjour();
			}
		});
		contentPane.add(btnNewButton_1);
		
		nameJtext = new JTextField("");
		nameJtext.setEditable(false);
		nameJtext.setBounds(106, 8, 200, 20);
		contentPane.add(nameJtext);
		nameJtext.setColumns(10);
		
		adresseJtext = new JTextField("");
		adresseJtext.setEditable(false);
		adresseJtext.setBounds(106, 33, 200, 20);
		contentPane.add(adresseJtext);
		adresseJtext.setColumns(10);
		
		contactJtext = new JTextField("");
		contactJtext.setEditable(false);
		contactJtext.setBounds(106, 58, 200, 20);
		contentPane.add(contactJtext);
		contactJtext.setColumns(10);
		
		telJtext = new JTextField("");
		telJtext.setEditable(false);
		telJtext.setBounds(106, 83, 200, 20);
		contentPane.add(telJtext);
		telJtext.setColumns(10);
		
		mailJtext = new JTextField("");
		mailJtext.setEditable(false);
		mailJtext.setBounds(106, 108, 200, 20);
		contentPane.add(mailJtext);
		mailJtext.setColumns(10);
		
		siteJtext = new JTextField("");
		siteJtext.setEditable(false);
		siteJtext.setBounds(106, 133, 200, 20);
		contentPane.add(siteJtext);
		siteJtext.setColumns(10);
		
		miseAjour();
	}
}
