package no.hvl.dat102;

/**
 * Karakter-eksempel.
 */
public class Karakter {

	// Beregn karakter
	// Poengsum mellom 0 and 100 (inklusive)
	public static char beregnKarakter(int poeng) throws FeilKarakterException {
		char kar;
		if (poeng < 0 || poeng > 100) {
			throw new FeilKarakterException("ulovlig poeng " + poeng);
		}

		if (poeng >= 90) {
			kar = 'A';
		} else if (poeng >= 80) {
			kar = 'B';
		} else if (poeng >= 60) {
			kar = 'C';
		} else if (poeng > 50) {// Logisk feil
			kar = 'D';
		} else if (poeng >= 40) {
			kar = 'E';
		} else {
			kar = 'F';
		}

		return kar;
	}

}
