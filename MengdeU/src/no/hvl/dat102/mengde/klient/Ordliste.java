package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;

import java.util.Scanner;

public class Ordliste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SwapClass.setX(1);
		SetADT<String> ordListe1 = SwapClass.retrieveClass();
		SetADT<String> ordListe2 = SwapClass.retrieveClass();

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}


		System.out.print("Oppgi en streng, avslutt med zzz :");
		String streng = tastatur.nextLine();
		// Leser inn ord
		while (!streng.equals("zzz")) {

			if (ordListe1.hasThis(streng)) {
				System.out.println("ordListe1 inneholder " + streng);
			} else {
				System.out.println("ordListe1 inneholder ikke " + streng);

			}
			// Legger innleste ord inn i ordliste2
			ordListe2.leggTil(streng);
			System.out.print("Oppgi en streng, avslutt med zzz :");
			streng = tastatur.nextLine();

		} // while

		// Lager unionen av de to ordlistene
		SetADT<String> ordListeBegge = SwapClass.retrieveClass();

		ordListeBegge = ordListe1.union(ordListe2);

		System.out.println("Utskrift av unionen av begge ordlistene");
		String hentStreng = "";
		while (!ordListeBegge.erTom()) {
			hentStreng = ordListeBegge.fjernTilfeldig();
			System.out.println(hentStreng);

		}

		// Lager snittet av de to ordlistene
		SetADT<String> ordListeFelles = SwapClass.retrieveClass();

		ordListeFelles = ordListe1.intersection(ordListe2);

		System.out.println("Utskrift av snittet av begge ordlistene");
		hentStreng = "";
		while (!ordListeFelles.erTom()) {
			hentStreng = ordListeFelles.fjernTilfeldig();
			System.out.println(hentStreng);

		}

		// Lager differansen av de to ordlistene
		SetADT<String> ordListeDiff = ordListe1.difference(ordListe2);

		System.out.println("Utskrift av differensen av begge ordlistene");
		hentStreng = "";
		while (!ordListeDiff.erTom()) {
			hentStreng = ordListeDiff.fjernTilfeldig();
			System.out.println(hentStreng);

		}

	}

}
