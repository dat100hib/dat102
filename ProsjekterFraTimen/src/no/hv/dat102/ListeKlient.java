package no.hv.dat102;

import java.util.LinkedList;
import java.util.List;

//Eks modifisert fra Mughals bok Java som første programmeringsspråk 
public class ListeKlient {
	static final String SENSUR = "SLADDET";
	static String ord[] = { "Java", "er", "gøy", "moro", "og", "kult", "mest", "gøy" };

	public static void main(String[] args) {
		
				         
		// List<String> ordliste = new ArrayList<String>();
		//Forenklet uten String som type i konstruktør    
		List<String> ordliste = new LinkedList<>();
		for (int i = 0; i < ord.length; i++) {
			ordliste.add(ord[i]);
		}
		System.out.println("Opprinnelig ordliste: " + ordliste);

		// Opprett en liste med ord som skal sladdes
		// List<String> sladdeteOrd = new ArrayList<>();
		List<String> sladdeteOrd = new LinkedList<>();
		sladdeteOrd.add("gøy");
		sladdeteOrd.add("kult");
		sladdeteOrd.add("morsom");

		// Sladd ord i ordlisten 

		for (String element : ordliste) {
			if (sladdeteOrd.contains(element)) {
				int indeks = ordliste.indexOf(element);
				ordliste.set(indeks, SENSUR);
			}
		}
		// Utskrift
		System.out.println("Sladdet ordliste: " + ordliste);
	}

}
