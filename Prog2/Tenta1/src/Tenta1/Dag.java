package Tenta1;

public class Dag {
	private int veckoNr, veckoDag;
	
	private static final String[] VDAGAR = {"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag"};
	
	public Dag(int veckoNr, int veckoDag) {
		if(veckoNr <1 || veckoNr > 53 || veckoDag < 0 || veckoDag > 6)
			throw new IllegalArgumentException();
		this.veckoDag = veckoDag;
		this.veckoNr = veckoNr;
	}
	
	public String toString() {
		return "vecka " + veckoNr + " " + VDAGAR[veckoDag];
	}

}
