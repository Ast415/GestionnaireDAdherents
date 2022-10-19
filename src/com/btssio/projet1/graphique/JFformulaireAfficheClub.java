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
	int id = 0;
	private ArrayList<Club> lesClub = new ArrayList<Club>();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	
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
		textField.setText(lesClub.get(id).getNom());
		textField_1.setText(lesClub.get(id).getAdresse());
		textField_2.setText(lesClub.get(id).getContact());
		textField_3.setText(lesClub.get(id).getTel());
		textField_4.setText(lesClub.get(id).getMail());
		textField_5.setText(lesClub.get(id).getSite());
		
	}
	
	/**
	 * Create the frame.
	 */
	public JFformulaireAfficheClub() {
		
		init();
		miseAjour();
		
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
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("adresse :");
		lblNewLabel_1.setBounds(10, 36, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("contact :");
		lblNewLabel_2.setBounds(10, 61, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("n° de Telephone :");
		lblNewLabel_3.setBounds(10, 86, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("@ mail :");
		lblNewLabel_4.setBounds(10, 111, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("site web :");
		lblNewLabel_5.setBounds(10, 136, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("precedent");
		btnNewButton.setBounds(10, 161, 86, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id > 0) {
					id = id - 1;
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("suivan");
		btnNewButton_1.setBounds(220, 161, 86, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id < lesClub.size()) {
					id = id + 1;
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(106, 8, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(106, 33, 200, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(106, 58, 200, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(106, 83, 200, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(106, 108, 200, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(106, 133, 200, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		init();
	}
}
