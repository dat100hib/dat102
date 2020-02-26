package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;
import no.hvl.dat102.mengde.tabell.ArraySet;

public class KlientBingo {
	// Oppretter 2 mengder med 75 bingokuler i hver.
	// Tester om en spesiell bingokule er med i den ene mengden,
	// og om de to mengdene er nøyaktig like.

	public static void main(String[] a) {
	int x =1;
		SwapClass<Bingokule> classSet = new SwapClass<>();
		final int ANTALL_BALLER = 53;
		SetADT<Bingokule> mengde1 = new ArraySet<Bingokule>();
		SetADT<Bingokule> mengde2 = new LinkedSet<Bingokule>();

		SwapClass.setX(1);
		SetADT<Bingokule> mengde3 = SwapClass.retrieveClass();
		SetADT<Bingokule> mengde4 = SwapClass.retrieveClass();

		Bingokule kule1 = null;
		Bingokule kule2 = null;

		for (int i = 1; i <= ANTALL_BALLER; i++) {
			kule1 = new Bingokule(i);
			kule2 = new Bingokule(ANTALL_BALLER + 1 - i);
			mengde3.leggTil(kule1);
			mengde4.leggTil(kule2);
		}
		System.out.println(mengde3);

		System.out.println("\nAntall kuler totalt: " + mengde3.antall());
		System.out.println();

		kule1 = new Bingokule(10);
		if (mengde3.hasThis(kule1)) {
			System.out.println("kule 1 funnet i mengde 1");
		}

		if (mengde3.equals(mengde4)) {
			System.out.println("Like mengder");
		}

		if (!mengde3.erTom()) {
			mengde3.fjern(kule1);
			if (!mengde3.equals(mengde4)) {
				System.out.println("Ulike mengder");
			}
		}

	}
}// class