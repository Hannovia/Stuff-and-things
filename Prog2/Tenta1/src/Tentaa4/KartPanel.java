package Tentaa4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KartPanel extends JPanel{
	private ImageIcon bild;
	
	public KartPanel (String filnamn) {
		setLayout(null);
		bild = new ImageIcon(filnamn);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bild.getImage(), 0, 0, this);
	}
}

class Kartan extends JFrame {
	Kartan(String filnamn){
		
		
		JPanel norra = new JPanel();
		add(norra, BorderLayout.NORTH);
		norra.add(new JLabel("Sträcka: "));
		norra.add(new JLabel("0"));
		norra.add(new JLabel("meter"));
		
		add(new KartPanel(filnamn));
		
		JPanel södra = new JPanel();
		add(södra, BorderLayout.SOUTH);
		södra.add(new JLabel("En pixel motsvarar: "));
		JTextField pixelField = new JTextField(3);
		södra.add(pixelField);
		södra.add(new JLabel("meter"));
		JButton okButton = new JButton("Ok");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 350);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Kartan(args[0]);
	}
}