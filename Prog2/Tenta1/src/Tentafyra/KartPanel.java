package Tentafyra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KartPanel extends JPanel {
	private ImageIcon bilden;
	
	public KartPanel(String filnamn) {
		setLayout(null); 
		bilden = new ImageIcon(filnamn);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bilden.getImage(), 0, 0, this);
	}
}

class Kartan extends JFrame {
	Kartan(String filnamn){
		JPanel norra = new JPanel();
		add(norra, BorderLayout.NORTH);
		norra.add(new JLabel("Sträcka: "));
		JLabel sträckaLabel = new JLabel("0");
		norra.add(sträckaLabel);
		norra.add(new JLabel(" meter"));
		
		add(new KartPanel(filnamn));
		
		JPanel södra = new JPanel();
		add(södra, BorderLayout.SOUTH);
		södra.add(new JLabel ("En pixel motsvarar: "));
		JTextField pixelFält = new JTextField(3);
		södra.add(pixelFält);
		södra.add(new JLabel("meter"));
		JButton okButton = new JButton("Ok");
		södra.add(okButton);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(650,350);
	}
	
	public static void main(String[] args) {
		new Kartan(args[0]);
	}
}