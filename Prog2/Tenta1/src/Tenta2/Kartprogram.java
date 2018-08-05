package Tenta2;

import javax.swing.*;
import java.awt.*;
import java.util.*;

class Kartprogram extends JPanel {
	private ImageIcon bild = new ImageIcon ("Plan6.png");
	private int x, y;
	private boolean visas = false;
	
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(bild.getImage(), 0, 0, this);
		if(visas) {
			g.setColor(Color.BLACK);
			g.fillOval(x-10, y-10, 15, 15);
		}
	}
	
	public void setXY(int x, int y) {
		this.x =x;
		this.y=y;
	}
	
	public void setVisas(boolean b) {
		visas=b;
		repaint();
	}
}

class Karta extends JFrame {
	String [] namn = {"Andrea", "Bea", "Birger", "Björn", "Dan", "David", "Elin", "Gistaf", "Henrik", "Ilja", "Jozef", "Lena", "Leon", "Louise", "Maria", "Martin", "Matts", "Patrik", "Paul", "Stefan", "Stewart", "Tessi"};
	
	Karta (){
		JPanel höger = new JPanel();
		add(höger, BorderLayout.WEST);
		JList<String> folkList = new JList<>(namn);
		folkList.setVisibleRowCount(20);
		höger.add(new JScrollPane(folkList));
		Kartprogram kp = new Kartprogram();
		add(kp, BorderLayout.CENTER);
		JPanel knappPanel = new JPanel();
		add(knappPanel, BorderLayout.SOUTH);
		knappPanel.add(new JButton("Visa"));
		knappPanel.add(new JButton ("Ange"));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(630, 450);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Karta();
	}
}
