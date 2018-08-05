package Tenta1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Djur {
	
	private String namn;
	private ArrayList <Grejer> samling = new ArrayList<>();
	
	public Djur (String namn) {
		this.namn = namn;
	}
	
	protected abstract boolean gillar(Grejer g);
	
	public void samla (List<Grejer> grejer) {
		Iterator <Grejer > iter = grejer.iterator();
		while(iter.hasNext()) {
			Grejer g = iter.next();
			if(gillar(g)) {
				iter.remove();
				samling.add(g);
			}
		}
	}
	
	class Ekorre extends Djur {
		
		public Ekorre (String namn) {
			super(namn);
		}
		
		protected boolean gillar(Grejer g) {
			return g instanceof Kotte || g instanceof Bär && ((Bär)g).getFärg().equals("Röd");
		}
	}
	
	class Skata extends Djur {
		
		public Skata (String namn) {
			super(namn);
		}
		
		protected boolean gillar(Grejer g) {
			return g.getVikt() >13;
		}
	}
}
