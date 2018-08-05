package Tenta2;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
import java.util.*;

abstract class Himlakroppar {
	private String namn;
	private int diameter;

	public Himlakroppar(String namn, int diameter) {
		this.namn = namn;
		this.diameter = diameter;
	}
	
	public String getNamn() {
		return namn;
	}
	
	public int getDiameter() {
		return diameter;
	}
	
	public abstract int getVikt();
	
//	protected abstract boolean hittaLiv(Himlakroppar h);
//	
//	public void hittaLiv (List<Himlakroppar> himlakroppar) {
//		Iterator<Himlakroppar> iter = himlakroppar.iterator();
//		while(iter.)
//	}
	
	class Planet extends Himlakroppar {
		private Måne månen = null;
		private boolean finnsLiv;
		
		public Planet(String namn, int diameter, Måne månen, boolean finnsLiv) {
			super(namn, diameter);
			this.finnsLiv = finnsLiv;
			this.månen = månen;
		}
		
		public int getVikt() {
			int vikt = 10 * getDiameter();
			if(månen != null)
				vikt += månen.getVikt();
			return vikt;
		}
		
		public void adderaMåne(Måne nyMåne) {
			if(månen == null || månen.getVikt() < nyMåne.getVikt())
				månen = nyMåne;
		}
		
		public boolean getFinnsLiv() {
			return finnsLiv;
		}
	}
	
	class Stjärna extends Himlakroppar{
		private int ljusstyrka;
		private ArrayList <Planet> planeter = new ArrayList<>();
		
		public Stjärna(String namn, int diameter, int ljusstyrka) {
			super(namn, diameter);
			this.ljusstyrka = ljusstyrka;
		}
		
		public void addPlanet(Planet pl) {
			planeter.add(pl);
		}
		
		public int getVikt() {
			int vikt =  ljusstyrka * getDiameter();
			for(Planet p : planeter)
				vikt += p.getVikt();
			return vikt;
		}
		
		public Collection<Planet> getPlaneter(){
			return planeter;
		}
	}

	class Måne extends Himlakroppar {
		private int kratrar;

		public Måne(String namn, int diameter, int kratrar) {
			super(namn, diameter);
			this.kratrar = kratrar;
		}
		
		public int getVikt() {
			return 10* getDiameter() - kratrar;
		}
	}

	class Austronaut {
		private void kollaKropp(Planet planet) {
			if (planet.getFinnsLiv())
				System.out.println(planet.getNamn());
		}

		public void letarLiv(Collection<Himlakroppar> himlakroppar) {
			for (Himlakroppar kropp : himlakroppar) {
				if (kropp instanceof Planet) {
					kollaKropp((Planet) kropp);
				} else if (kropp instanceof Stjärna) {
					for (Planet p : ((Stjärna) kropp).getPlaneter())
						kollaKropp(p);
				}
			}
		}
	}
}
