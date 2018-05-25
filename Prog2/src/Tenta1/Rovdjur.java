package Tenta1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Rovdjur extends JFrame {
	static final String[] DJUREN = { "Varg", "Lodjur", "Björn", "Järv", "Kungsörn" };

	JList<String> listan = new JList<>(DJUREN);
	
	String nyArt;
	int antal;

	public Rovdjur() {
		JPanel västra = new JPanel();
		add(västra, BorderLayout.WEST);
		västra.setLayout(new BoxLayout(västra, BoxLayout.Y_AXIS));
		listan.setVisibleRowCount(5);
		listan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		västra.add(new JScrollPane(listan));
		
		
		västra.add(new JLabel("Annan art:"));
		JTextField artField = new JTextField(10);
		västra.add(artField);
		nyArt = artField.getText();

		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		add(center, BorderLayout.CENTER);
		JPanel rad1 = new JPanel();
		center.add(rad1);
		
		rad1.add(new JLabel("Antal:"));
		JTextField antalField = new JTextField(5);
		rad1.add(antalField);
		antal = Integer.parseInt(antalField.getText());
		
		
		JPanel rad2 = new JPanel();
		center.add(rad2);
		
		JButton adderaKnapp = new JButton("Addera");
		rad2.add(adderaKnapp);
		adderaKnapp.addActionListener(new AdderaLyss());
		
		JButton visaKnapp = new JButton("Addera");
		rad2.add(visaKnapp);
		visaKnapp.addActionListener(new VisaLyss());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 170);
		setVisible(true);
	}
	
	class AdderaDjur extends JPanel{
//		public String get
	}
	
	public class AdderaLyss implements ActionListener{
		public void actionPerformed (ActionEvent ave){
			
		}
	}
	
	public class VisaLyss implements ActionListener {
		public void actionPerformed (ActionEvent ave) {
			
		}
	}

	public static void main(String[] args) {
		new Rovdjur();
	}
}