package Tenta1;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PredatorUI extends JFrame {
	JList <Predator> predatorList = new JList<>();
	
	public PredatorUI () {
		setLayout (new BorderLayout());
		
		JButton adderaButton = new JButton("Addera");
		JButton visaButton = new JButton("Visa");
		JLabel antalLabel = new JLabel("Antal: ");
		JTextField antalField = new JTextField(10);
		
		JPanel east = new JPanel();
		add(east, BorderLayout.EAST);
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.add(antalLabel);
		east.add(antalField);
		east.add(adderaButton);
		east.add(visaButton);
		
		JPanel west = new JPanel();
		JTextField otherSpecies = new JTextField(6);
		JLabel annanArtLabel = new JLabel("Annan art: ");
		add(west, BorderLayout.WEST);
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.add(predatorList);
		west.add(annanArtLabel);
		west.add(otherSpecies);
		
		setVisible(true);
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main (String[]arg) {
		new PredatorUI();
	}
}
