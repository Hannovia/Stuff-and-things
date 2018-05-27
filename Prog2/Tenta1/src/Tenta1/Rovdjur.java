package Tenta1;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rovdjur {
	private String art;
	private int antal;
	
	public Rovdjur(String art, int antal) {
		this.art=art;
		this.antal=antal;
	}
	
	public String getArt() {
		return art;
	}
	
	public int getAntal() {
		return antal;
	}
	
	public String toString() {
		return getArt() + ": " + getAntal();
	}
	
	
	public void getBeskrivning() {
		JPanel rovdjurobs = new JPanel();
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		JLabel info = new JLabel(getArt() + ": " + getAntal());
		JLabel info1 = new JLabel("Test");
		rovdjurobs.add(info1);
		infoPanel.add(info);
		
		JOptionPane.showMessageDialog(null, infoPanel, "Rovdjursobservatoner: ", JOptionPane.INFORMATION_MESSAGE);
		
	
	}

}
