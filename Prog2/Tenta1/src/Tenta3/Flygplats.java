package Tenta3;
import java.util.*;

public class Flygplats{
	String destination;
	Map<String, List<Klocka>> departures = new HashMap<String, List<Klocka>>();
}

class Klocka implements Comparable<Klocka> {
	private int timme, minuter;
	public Klocka(int timme, int minuter) {
		this.timme=timme;
		this.minuter=minuter;
	}
	
	public String toString() {
		return timme + ": " +minuter;
	}
	
	public int compareTo(Klocka other) {
		int cmp = timme - other.timme;
		if(cmp!=0)
			return cmp;
		else
			return minuter - other.minuter;
	}
	
	static Map<Klocka, List<String>> vändMap(Map<String, List<Klocka>> orgMap) {
		Map<Klocka, List<String>> resultat = new TreeMap<>();
		for (Map.Entry<String, List<Klocka>> me : orgMap.entrySet()) {
			// Klocka klocka = entry.getKey();
			String destination = me.getKey();

			List<Klocka> tider = me.getValue();

			for (Klocka kl : tider) {
				List<String> destinationer = resultat.get(kl);
				if (destinationer == null) {
					destinationer = new ArrayList<String>();
					resultat.put(kl, destinationer);
				}

				destinationer.add(destination);
			}
		}
		return resultat;
	}
}

