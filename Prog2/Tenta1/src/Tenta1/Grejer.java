package Tenta1;

public abstract class Grejer {
	private int näringsvärde;
	private int vikt;
	
//	abstract public String getMogen();

	class Bär extends Grejer {
		private String färg;
		
		public Bär(int näringsvärde, int vikt, String färg) {
			
		}
		
		public String ändraFärg() {
			return null;
		}
		
		public String getFärg() {
			return färg;
		}
		
		public int getNäringsvärde() {
			if(färg.equals("Röd") || färg.equals("Blå"))
				näringsvärde = 23;
			else 
				näringsvärde = vikt;
			return näringsvärde;
		}
	}
	
	class Kotte extends Grejer {
		private boolean ärMogen;
		
		public Kotte (int näringsvärde, int vikt, boolean ärMogen) {
			this.ärMogen = ärMogen;
		}
		
//		public String getMogen() {
//			if(ärMogen)
//				return "Mogen";
//			else
//				return "Inte mogen";
//		}
		
		public int getNäringsvärde() {
			näringsvärde = vikt * 3;
			if (ärMogen = true)
				näringsvärde = näringsvärde * 2;
			
			return näringsvärde;
		}
	}
}
