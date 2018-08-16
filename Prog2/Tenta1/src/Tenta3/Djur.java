package Tenta3;
import java.util.*;

abstract class Djur {
	private String namn;
	private int vikt;
	
//	public abstract double getSnabel();
	public abstract double getVärde();
	
	public Djur(String namn, int vikt) {
		this.namn = namn;
		this.vikt = vikt;
	}
	
	public String getNamn() {
		return namn;
	}
	
	public int getVikt() {
		return vikt;
	}
}

class Elefant extends Djur{
	private double snabelLängd;
	
	public Elefant(String namn, int vikt, double snabelLängd) {
		super(namn, vikt);
		this.snabelLängd = snabelLängd;
	}
	
	public double getSnabel() {
		return snabelLängd;
	}
	
	public double getVärde() {
		return getSnabel() * getVikt();
	}
}

class Orm extends Djur{
	private boolean ärGiftig;
	
	public Orm(String namn, int vikt, boolean ärGiftig) {
		super(namn, vikt);
		this.ärGiftig = ärGiftig;
	}
	
	public boolean getGiftig() {
		return ärGiftig;
	}
	
	public double getVärde() {
		if(ärGiftig)
			return getVikt() + 2000.0;
		else
			return getVikt() + 5.0;
	}
}

class MainClass {
	public static void main(String[]args) {
		ArrayList<Djur> djurLista = new ArrayList<>();
		
		djurLista.add(new Elefant("Jumbo", 3000, 2.3));
		djurLista.add(new Orm("Hugo", 2, true));
		
		double värdesumma = 0, snabelsumma = 0, antalElefanter = 0;
		
		for(Djur d : djurLista) {
			värdesumma += d.getVärde();
			if(d instanceof Elefant) {
				Elefant effe = (Elefant)d;
				snabelsumma += effe.getSnabel();
				antalElefanter ++;
			}
		}
		
		System.out.println("Medel: " + snabelsumma/antalElefanter);
		System.out.println("Totalvärde: " + värdesumma);
	}
}
