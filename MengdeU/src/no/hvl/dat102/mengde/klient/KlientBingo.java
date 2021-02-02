package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class KlientBingo {
	// Oppretter 2 mengder med 75 bingokuler i hver.
	// Tester om en spesiell bingokule er med i den ene mengden,
	// og om de to mengdene er nøyaktig like.

	public static void main(String[] a) {
		final int ANTALL_BALLER = 75;
		MengdeADT<Bingokule> mengde1 = new KjedetMengde<>();
		MengdeADT<Bingokule> mengde2 = new KjedetMengde<>();
		Bingokule kule1 = null;
		Bingokule kule2 = null;

		for (int i = 1; i <= ANTALL_BALLER; i++) {
			kule1 = new Bingokule(i);
			kule2 = new Bingokule(ANTALL_BALLER + 1 - i);
			mengde1.leggTil(kule1);
			mengde2.leggTil(kule2);
		}

		System.out.println("\nAntall kuler totalt: " + mengde1.antall());
		System.out.println();

		kule1 = new Bingokule(10);
		if (mengde1.inneholder(kule1)) {
			System.out.println("kule 1 funnet i mengde 1");
		}

		if (mengde1.equals(mengde2)) {
			System.out.println("Like mengder");
		}

		if (!mengde1.erTom()) {
			mengde1.fjern(kule1);
			if (!mengde1.equals(mengde2)) {
				System.out.println("Ulike mengder");
			}
		}

	}
}// class