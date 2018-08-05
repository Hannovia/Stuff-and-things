package Tenta3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Kassa extends JFrame{
	final String[] VAROR = {"Gurka", "Paprike", "Tomat", "Mjölk", "Yoghurt", "Grädde", "Bröd", "Mûsli", "Kakor"};
	private static final double[] PRISER = {11.70, 46.30, 27.35, 7.50, 15.50, 13.72, 23.20, 27.30, 13.00};
	private JTextField antalField;
	private JLabel antalLabel;
	private JLabel totalbelopp;
	private JLabel totalLabel;
	private double totalt = 0.0;
	private Map<String, Double> prisLista = new HashMap<>();
	private JTextArea area = new JTextArea();
	
	JButton b;
	JTextArea display;

	
	public Kassa() {
		super("Kassa");
		for(int i = 0; i<VAROR.length; i++)
			prisLista.put(VAROR[i], PRISER[i]);
		
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		
		JButton nyKundKnapp = new JButton("Ny kund");
		north.add(nyKundKnapp);
		nyKundKnapp.addActionListener(new NyKundLyss());
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,1));
		add(center, BorderLayout.CENTER);
		JPanel knappar = new JPanel();
		center.add(knappar);
		knappar.setLayout(new GridLayout(3,3,10,10));
		
		VarorLyss varaLyss = new VarorLyss();
		for(int i = 0; i < VAROR.length; i++) {
			b = new JButton(VAROR[i]);
			knappar.add(b);
			b.addActionListener(varaLyss);
		}
		
		display = new JTextArea();
		center.add(new JScrollPane (display));
		display.setEditable(false);
		
		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);
		antalLabel = new JLabel("Antal: ");
		south.add(antalLabel);
		
		antalField = new JTextField(5);
		south.add(antalField);
		
		totalLabel = new JLabel("Totalbelopp = ");
		south.add(totalLabel);
		
		totalbelopp = new JLabel("" + totalt);
		south.add(totalbelopp);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
	
	class NyKundLyss implements ActionListener{
		public void actionPerformed (ActionEvent ave) {
			totalt = 0;
			totalbelopp.setText("" + totalt);
			antalField.setText("");
			display.setText("");
		}
	}
	
	class VarorLyss implements ActionListener {
		public void actionPerformed (ActionEvent ave) {
			try {
				JButton b = (JButton)ave.getSource();
				String vara = b.getText();
				int antal = Integer.parseInt(antalField.getText());
				double totalbelopp = antal * prisLista.get(vara);
				area.append(vara + " " + antal + " " + String.format("%.2f", totalbelopp) + "\n");
				totalt += totalbelopp;
				
				totalLabel.setText(String.format("%.2f", totalbelopp));
				
				display.setText("");
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Fel antal!");
			}

		}
	}
	
	public static void main(String[] args) {
		new Kassa();
	}
}
