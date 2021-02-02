package no.hvl.dat102;

import java.util.Scanner;

public class PostfixKlient {

	public static void main(String[] args) {

		String uttrykk;
		String igjen;
		int resultat;

		Scanner tastatur = new Scanner(System.in);
		do {
			PostfixEvaluator evaluator = new PostfixEvaluator();
			System.out.println(
					"Oppgi et gyldig postfix-uttrykk med en " + "blank mellom hvert tegn " 
			          + "Eks  4 5 2 * + som blir 14 ");
			uttrykk = tastatur.nextLine();
			resultat = evaluator.beregn(uttrykk);
			System.out.println();
			System.out.println("Uttrykket er lik " + resultat);
			System.out.print("Oppgi et nytt uttrykk  j/n? ");
			igjen = tastatur.nextLine();
		} while (igjen.equalsIgnoreCase("j"));

	}

}
