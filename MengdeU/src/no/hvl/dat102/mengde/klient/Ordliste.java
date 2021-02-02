package no.hvl.dat102.mengde.klient;

import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Ordliste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MengdeADT<String> ordListe1 = new KjedetMengde<String>();

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Førde","Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}
		MengdeADT<String> ordListe2 = new KjedetMengde<String>();

		System.out.println("Oppgi en streng, avslutt med zzz:");
		String streng = tastatur.nextLine();
		// Leser inn ord
		while (!streng.equals("zzz")) {

			if (ordListe1.inneholder(streng)) {
				System.out.println("ordListe1 inneholder " + streng);
			} else {
				System.out.println("ordListe1 inneholder ikke " + streng);

			}
			// Legger innleste ord inn i ordliste2
			ordListe2.leggTil(streng);
			System.out.println("Oppgi en streng, avslutt med zzz:");
			streng = tastatur.nextLine();

		} // while

		// Lager unionen av de to ordlistene
		MengdeADT<String> ordListeBegge = new KjedetMengde<String>();

		ordListeBegge = (KjedetMengde<String>) ordListe1.union(ordListe2);

		System.out.println("\nUtskrift av unionen av begge ordlistene");
		String hentStreng = "";
		while (!ordListeBegge.erTom()) {
			hentStreng = ordListeBegge.fjernTilfeldig();
			System.out.println(hentStreng);

		}

		// Lager snittet av de to ordlistene
		MengdeADT<String> ordListeFelles = new KjedetMengde<String>();

		ordListeFelles = (KjedetMengde<String>) ordListe1.snitt(ordListe2);

		System.out.println("\nUtskrift av snittet av begge ordlistene");
		hentStreng = "";
		while (!ordListeFelles.erTom()) {
			hentStreng = ordListeFelles.fjernTilfeldig();
			System.out.println(hentStreng);

		}

		// Lager differansen av de to ordlistene
		MengdeADT<String> ordListeDiff = new KjedetMengde<String>();

		ordListeDiff = (KjedetMengde<String>) ordListe1.differens(ordListe2);

		System.out.println("\nUtskrift av differensen av begge ordlistene");
		hentStreng = "";
		while (!ordListeDiff.erTom()) {
			hentStreng = ordListeDiff.fjernTilfeldig();
			System.out.println(hentStreng);

		}

	}

}
