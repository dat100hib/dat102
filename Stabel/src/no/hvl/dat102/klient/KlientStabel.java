package no.hvl.dat102.klient;

import no.hvl.dat102.EmptyCollectionException;
import no.hvl.dat102.tabell.TabellStabel;
import no.hvl.dat102.adt.*;

public class KlientStabel {
	public static void main(String[] args) {

		String str = "netsket re etteD";
		int lengde = str.length();
		StabelADT<Character> tegnStabel = new TabellStabel<>();
		for (int i = 0; i < lengde; i++) {
			tegnStabel.push((str.charAt(i)));
		}
		
		System.out.println(str);
		try {
			while (!tegnStabel.erTom()) {
				char tegn = tegnStabel.pop();
				System.out.print(tegn);
			}
			System.out.println();
		} catch (EmptyCollectionException ex) {
			System.out.println(ex.getMessage());
		}
	} 

}// class
