package no.hvl.dat102;



//  Tabellimplementasjon av en stabel.
//********************************************************************

public class TabellStabel<T> implements StabelADT<T> {
	private final static int STDK = 100;
	private int topp; // indikerer neste plass
	private T[] stabel;

	/*******************************************************************
	 * Oppretter en tom stabel.
	 *******************************************************************/
	
	public TabellStabel() {
		this(STDK);		
	}

	/*******************************************************************
	 * Oppretter en tom stabel med en speisfisert kapasitet.
	 *******************************************************************/
	public TabellStabel(int startKapasitet) {
		topp = 0;
		stabel = (T[]) (new Object[startKapasitet]);
	}

	/*******************************************************************
	 * Legger til det spesifiserte elementet på toppen av stabelen, utvider
	 * kapasitetet til stabelen hvis nødvendig.
	 *******************************************************************/
	@Override
	public void push(T element) {
		if (antall() == stabel.length)
			utvid();

		stabel[topp] = element;
		topp++;
	}

	/*******************************************************************
	 * 
	 * Fjerner toppelementet og returnerer en referanse til den. Hvis stabelen
	 * er tom fra før, så kastes unntak
	 *******************************************************************/
	@Override
	public T pop()  {
		if (erTom())
			throw new EmptyCollectionException("Stabel");

		topp--;
		T result = stabel[topp];
		stabel[topp] = null;

		return result;
	}

	/*******************************************************************
	 * Returnerer toppelementet uten å fjerne det. Hvis stabelen er tom fra
	 * før, så kastes unntak
	 *******************************************************************/
	@Override
	public T peek()  {
		if (erTom())
			throw new EmptyCollectionException("Stabel");

		return stabel[topp - 1];
	}

	/*******************************************************************
	 * Returnerer sann hvis stabelen er tom og usann ellers.
	 *******************************************************************/
	@Override
	public boolean erTom() {
		return (topp == 0);
	}

	/*******************************************************************
	 * Returnerer antall elementer.
	 *******************************************************************/
	@Override
	public int antall() {
		return topp;
	}

	
	/*******************************************************************
	 * Oppretter en ny tabell for å lagre innholdet.
	 *******************************************************************/
	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[stabel.length * 2]);

		for (int indeks = 0; indeks < stabel.length; indeks++)
			hjelpeTabell[indeks] = stabel[indeks];

		stabel = hjelpeTabell;
	}
}
