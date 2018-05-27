package Tenta1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class RovdjurUI extends JFrame {
	static final String[] DJUREN = { "Varg", "Lodjur", "Björn", "Järv", "Kungsörn" };

	JList<String> listan = new JList<>(DJUREN);
	
	ArrayList<Rovdjur> rovdjurslista = new ArrayList<>();
	
	String nyArt;
	String art;
	Rovdjur r;
	int antal;
	JTextField antalField;
	JTextField artField;

	public RovdjurUI() { 
		JPanel västra = new JPanel();
		add(västra, BorderLayout.WEST);
		västra.setLayout(new BoxLayout(västra, BoxLayout.Y_AXIS));
		listan.setVisibleRowCount(5);
		listan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		västra.add(new JScrollPane(listan));
		
		
		västra.add(new JLabel("Annan art:"));
		artField = new JTextField(10);
		västra.add(artField);
		

		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		add(center, BorderLayout.CENTER);
		JPanel rad1 = new JPanel();
		center.add(rad1);
		
		rad1.add(new JLabel("Antal:"));
		antalField = new JTextField(5);
		rad1.add(antalField);
		
		
		JPanel rad2 = new JPanel();
		center.add(rad2);
		
		JButton adderaKnapp = new JButton("Addera");
		rad2.add(adderaKnapp);
		adderaKnapp.addActionListener(new AdderaLyss());
		
		JButton visaKnapp = new JButton("Visa");
		rad2.add(visaKnapp);
		visaKnapp.addActionListener(new VisaLyss());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 170);
		setVisible(true);
	}
	
	public void AdderaDjur() {
		
		if(art == null) {
			nyArt = artField.getText();
		} else {
			art = listan.getSelectedValue();
		}
		antal = Integer.parseInt(antalField.getText());

		Rovdjur r = new Rovdjur(art, antal);
		
		if(rovdjurslista.contains(art)) {
			antal += antal;
		}
		rovdjurslista.add(r);
		
		
	}
	
	public class AdderaLyss implements ActionListener{
		public void actionPerformed (ActionEvent ave){
			AdderaDjur();
		}
	}
	
	public class VisaLyss implements ActionListener {
		public void actionPerformed (ActionEvent ave) {
			for(Rovdjur r: rovdjurslista) {
				r.getBeskrivning();
			}
		}
	}

	public static void main(String[] args) {
		new RovdjurUI();
	}
}