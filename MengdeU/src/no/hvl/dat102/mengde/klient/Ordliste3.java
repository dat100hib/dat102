package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;

public class Ordliste3 {

	public static void main(String[] args) {

		SwapClass.setX(1);


		SetADT<String> ordListe1 = SwapClass.retrieveClass();

		String[] ord1 = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		String[] ord2 = { "God", "Hei", "Eva", "Oslo", "Førde", "Olsen", };

		String[] ord3 = { "God", "dag", "Hans", "Olsen", "Ole", "rute",};
		for (int i = 0; i < ord1.length; i++) {
			ordListe1.leggTil(ord1[i]);
		}

		SetADT<String> ordListe2 =SwapClass.retrieveClass();
		SetADT<String> ordListe3 = SwapClass.retrieveClass();
		for (int i = 0; i < ord2.length; i++) {
			ordListe2.leggTil(ord2[i]);
			ordListe3.leggTil(ord3[i]);
		}

		// Lager unionen av de to ordlistene

		SetADT<String> ordListeBegge = SwapClass.retrieveClass();

		ordListeBegge = ordListe1.union(ordListe2);

		System.out.println("Utskrift av unionen av begge ordlistene");
		String hentStreng = "";
		while (!ordListeBegge.erTom()) {
			hentStreng = ordListeBegge.fjernTilfeldig();
			System.out.println(hentStreng);

		}
		System.out.println(ordListe1.subSet(ordListe3));
		System.out.println(ordListe1.subSet(ordListe2));

	}

}
