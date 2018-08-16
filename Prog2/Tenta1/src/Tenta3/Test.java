package Tenta3;

import java.util.*; 
class Elefant{ 
    private String namn; 
    private int vikt; 
    private double snabel; 
    public Elefant(String namn, int vikt, double snabel){ 
       this.namn = namn; 
       this.vikt = vikt; 
       this.snabel = snabel; 
    } 
    public String getNamn() { 
    	return namn; 
    } 
    public int getVikt(){ 
    	return vikt; 
    } 
    public double getSnabel() {
    	return snabel; 
    } 
    public double getVärde()  { 
    	return snabel * vikt; 
    } 
}  

class Orm{ 
    private String namn; 
    private int vikt; 
    private boolean giftig; 
    public Orm(String namn, int vikt, boolean giftig){ 
       this.namn = namn; 
       this.vikt = vikt; 
       this.giftig = giftig; 
    } 
    public String getNamn() { return namn; } 
    public int getVikt() { return vikt; } 
    public boolean isGiftig(){ 
       return giftig; 
    } 
    public double getVärde(){ 
       if (giftig) 
          return vikt + 2000.0; 
       else 
          return vikt + 5.0; 
    } 
} 
class MainClass{ 
    public static void main(String[] args){ 
       ArrayList<Elefant> flock = new ArrayList<>(); 
       flock.add(new Elefant("Jumbo", 3000, 2.3)); 
       // En massa fler Elefant-objekt skapas och stoppas in i flock 
       ArrayList<Orm> ormGrupp = new ArrayList<>(); 
       ormGrupp.add(new Orm("Hugo", 2, true)); 
       // En massa fler Orm-objekt skapas och stoppas in i ormGrupp 
       double värdeSumma = 0; 
       double snabelSumma = 0; 
       for(Elefant effe : flock){ 
          värdeSumma += effe.getVärde(); 
          snabelSumma += effe.getSnabel(); 
       } 
       for(Orm snok : ormGrupp) 
          värdeSumma += snok.getVärde(); 
       System.out.println("Medel: " + snabelSumma/flock.size()); 
       System.out.println("Totalvärde: " + värdeSumma); 
    } 
} 