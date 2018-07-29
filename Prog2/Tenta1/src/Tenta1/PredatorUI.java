package Tenta1;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PredatorUI extends JFrame {
	static final String[] ANIMALS = {"Varg", "Lodjur", "Björn", "Järv", "Kungsörn"};
	JList <String> predatorList = new JList<>(ANIMALS);
	
	Map<String, Integer> allAnimals = new HashMap<>();
	
	String animal;
	String newAnimal;
	JLabel annanArtLabel;
	JTextField antalField;
	
	public PredatorUI () {
		setLayout (new BorderLayout());
		
		JButton adderaButton = new JButton("Addera");
		adderaButton.addActionListener(new AdderaLyss());
		JButton visaButton = new JButton("Visa");
		visaButton.addActionListener(new visaLyss());
		JLabel antalLabel = new JLabel("Antal: ");
		antalField = new JTextField(5);
		
		JPanel center = new JPanel();
		add(center, BorderLayout.CENTER);
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

		JPanel row1 = new JPanel();
		center.add(row1);
		row1.add(antalLabel);
		row1.add(antalField);
		center.add(adderaButton);
		center.add(visaButton);
		
		JPanel west = new JPanel();
		JTextField otherSpecies = new JTextField(10);
		annanArtLabel = new JLabel("Annan art: ");
		add(west, BorderLayout.WEST);
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.add(predatorList);
		west.add(annanArtLabel);
		west.add(otherSpecies);
		
		predatorList.setVisibleRowCount(5);
		predatorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		west.add(new JScrollPane (predatorList));
		
		setVisible(true);
		setSize(300, 170);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	class Predator{
		public Predator(String animal, int antal) {
	
		}
	}
	
	class visaLyss implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			String str = "Rovdjursobservationer: \n";
			
			for(Map.Entry<String, Integer>entry:allAnimals.entrySet())
				str += entry.getKey() + ": " + entry.getValue() + "\n";
			JOptionPane.showMessageDialog(PredatorUI.this, str);
		}
	}
	
	class AdderaLyss implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
			try {
				String selection = predatorList.getSelectedValue();
				if (selection == null) {
					selection = annanArtLabel.getText();
				}
				if (selection.equals("")) {
					JOptionPane.showMessageDialog(null, "Ingen art angiven");
					return;
				}

				int antal = Integer.parseInt(antalField.getText());
				Integer oldAntal = allAnimals.get(selection);

				if (oldAntal != null)
					antal += oldAntal;
				allAnimals.put(selection, antal);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Fel antal angivet!");
			}
		}
	}
	
	public static void main (String[]args) {
		new PredatorUI();
	}
}
