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
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class JFformulaireAfficheClub extends JFrame {

	protected static boolean formEstOuvert = false;
	private JPanel contentPane;
	int id = 0;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFformulaireAfficheClub.class.getResource("/img/logoM1Icon.png")));
		setResizable(false);
		setTitle("Menu informatif des clubs");
		
		init();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				formEstOuvert=false;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nom = new JLabel("Nom :");
		nom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nom.setBounds(10, 88, 127, 14);
		contentPane.add(nom);
		
		JLabel adresse = new JLabel("Adresse :");
		adresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adresse.setBounds(10, 113, 127, 14);
		contentPane.add(adresse);
		
		JLabel contact = new JLabel("Contact :");
		contact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contact.setBounds(10, 138, 127, 14);
		contentPane.add(contact);
		
		JLabel telephone = new JLabel("N° de Telephone :");
		telephone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telephone.setBounds(10, 163, 127, 14);
		contentPane.add(telephone);
		
		JLabel mail = new JLabel("Email :");
		mail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mail.setBounds(10, 188, 127, 14);
		contentPane.add(mail);
		
		JLabel siteWeb = new JLabel("Site web :");
		siteWeb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		siteWeb.setBounds(10, 213, 127, 14);
		contentPane.add(siteWeb);
		
		JButton btnNewButton = new JButton("Precedent");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(114, 250, 98, 31);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id > 0) {
					id = id - 1;
				}
				miseAjour();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Suivant");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(222, 250, 98, 31);
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
		nameJtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameJtext.setEditable(false);
		nameJtext.setBounds(147, 85, 276, 20);
		contentPane.add(nameJtext);
		nameJtext.setColumns(10);
		
		adresseJtext = new JTextField("");
		adresseJtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adresseJtext.setEditable(false);
		adresseJtext.setBounds(147, 110, 276, 20);
		contentPane.add(adresseJtext);
		adresseJtext.setColumns(10);
		
		contactJtext = new JTextField("");
		contactJtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contactJtext.setEditable(false);
		contactJtext.setBounds(147, 135, 276, 20);
		contentPane.add(contactJtext);
		contactJtext.setColumns(10);
		
		telJtext = new JTextField("");
		telJtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telJtext.setEditable(false);
		telJtext.setBounds(147, 160, 276, 20);
		contentPane.add(telJtext);
		telJtext.setColumns(10);
		
		mailJtext = new JTextField("");
		mailJtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mailJtext.setEditable(false);
		mailJtext.setBounds(147, 185, 276, 20);
		contentPane.add(mailJtext);
		mailJtext.setColumns(10);
		
		siteJtext = new JTextField("");
		siteJtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		siteJtext.setEditable(false);
		siteJtext.setBounds(147, 210, 276, 20);
		contentPane.add(siteJtext);
		siteJtext.setColumns(10);
		
		JLabel lblMenuInformatifDes = new JLabel("Menu informatif des clubs");
		lblMenuInformatifDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuInformatifDes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenuInformatifDes.setBounds(10, 11, 413, 66);
		contentPane.add(lblMenuInformatifDes);
		
		miseAjour();
	}
}
