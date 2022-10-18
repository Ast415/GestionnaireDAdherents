package com.btssio.projet1.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.btssio.projet1.classe.lectureXML;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JFformulaireMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFformulaireMenu frame = new JFformulaireMenu();
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
	public JFformulaireMenu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Quitte l'application.
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JFformulaireAdherents.formEstOuvert==false) {//Si la formulaire adhérent est fermée 
					JFformulaireAdherents.formEstOuvert=true;//Alors on définit la variable comme true
					new JFformulaireAdherents().setVisible(true);//Et on ouvre le formulaire 
				}
			}
		});
		btnNewButton.setBounds(76, 126, 137, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Afficher");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JFformulaireAfficher.formEstOuvert==false) {//Si la formulaire adhérent est fermée 
					try {
						if (lectureXML.importationXMLadherent()==null) {//Empeche l'ouverture si il n'y a pas d'adherent dans le fichier
							JOptionPane.showMessageDialog(contentPane,"Il n'y a pas d'ahderent enregistrer");
						}else {
							JFformulaireAfficher.formEstOuvert=true;//Alors on définit la variable comme true
							new JFformulaireAfficher().setVisible(true);//Et on ouvre le formulaire 
						}
					} catch (HeadlessException | ParserConfigurationException | SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(223, 126, 137, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Menu du gestionnaire des adhérents");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 30, 414, 74);
		contentPane.add(lblNewLabel);
	}
}
