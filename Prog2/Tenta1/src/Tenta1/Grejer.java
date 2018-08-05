package Tenta1;

import java.util.*;

public abstract class Grejer {
	private int vikt;
	
	public Grejer (int vikt) {
		this.vikt=vikt;
	}
	
	public int getVikt() {
		return vikt; 
	}
	
	class Bär extends Grejer {
		private String färg;
		
		public Bär(int vikt, String färg) {
			super(vikt);
			this.färg = färg;
		}
		
		public String ändraFärg(String nyFärg) {
			this.färg = nyFärg;
			return färg;
		}
		
		public String getFärg() {
			return färg;
		}
		
		public int getNäringsvärde() {
			if(färg.equals("Röd") || färg.equals("Blå"))
				return 23;
			else 
				return getVikt();
		}
	}
	
	class Kotte extends Grejer {
		private boolean ärMogen;
		
		public Kotte (int vikt, boolean ärMogen) {
			super(vikt);
			this.ärMogen = ärMogen;
		}
		
		public boolean ärMogen() {
			return ärMogen;
		}
		
		public int getNäringsvärde() {
			int näring = vikt * 3;
			if (ärMogen)
				näring *= 2;
			
			return näring;
		}
	}
}
