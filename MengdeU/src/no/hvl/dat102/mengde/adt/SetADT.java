package no.hvl.dat102.mengde.adt;

import java.util.Iterator;

public interface SetADT<T> {
	/* De abstrakte  metodene under svarer til operasjoner i en ADT for en mengde */

	/**
	 * Legger til et element til dette mengde-objektet (this) hvis det ikke fins fra
	 * før
	 * 
	 * @param element som skal legges til betinget
	 */
	void  leggTil(T element);

	/**
	 * 
	 * @param m2 er mengden som skal legges til denne mengden Legger til de
	 *           elementer i m2 som ikke fins fra før i denne mengden m1 (this).
	 */
	void addAll(SetADT<T> m2);

	/**
	 * Fjerner og returnerer et tilfeldig element fra mengden
	 * 
	 * @return returnerer det tilfeldige elementet ellers returneres null
	 * @exception EmptyCollectionException unntak kastes hvis mengden allerede er
	 *                                     tom
	 * 
	 */
	T fjernTilfeldig();

	/**
	 * 
	 * @param element er elementet som skal fjernes hvis det fins ellers returneres
	 *                null
	 * @return elementet som fjernes
	 * @exception EmptyCollectionException unntak kastes hvis mengden allerede er
	 *                                     tom
	 * 
	 */
	T fjern(T element);

	
	boolean hasThis(T element);

	/**
	 * Tester om this-mengden og parameteren inneholder nøyaktig de samme elementene
	 * 
	 * @param m2 er mengden som testes
	 * @return sann hvis m1 og m2  er like ellers usann
	 */
	boolean equals(Object m2);

	/**
	 * Tester om mengden er tom (dvs. har 0 element)
	 * 
	 * @return sann hvis mendgen er tom ellers usann
	 */
	boolean erTom();

	/**
	 * Finner antall elementer i mengden
	 * 
	 * @return antall i mengden
	 */
	int antall();
	
	/**
	 * 
	 * @param m2 er mengden det skal lages union med.
	 * @return er union av mengden m2 og m1(this)-mengden
	 */
	SetADT<T> union(SetADT<T> m2);

	/**
	 * 
	 * @param element er det gitte elementet
	 * @return sann hvis elementet fins ellers usann
	 */

	/**
	 * Lager en ny mengde som er snittet av mengden m1 og m2
	 * 
	 * @param m2 er parameter
	 * @return snittet av de to mengdene
	 */
	SetADT<T> intersection(SetADT<T> m2);

	/**
	 * Lager en ny mengde som er differensen av m1 og m2.
	 * 
	 * @param m2 er parameteren
	 * @return differensen av de to mengdene
	 */
	SetADT<T> difference(SetADT<T> m2);

	/**
	 * 
	 * @param m2 er parameteren
	 * @return sann hvis m2 er en undermengde av m1, ellers usann
	 */
	public boolean subSet(SetADT<T> m2);

	/**
	 * 
	 * Oppretter et 'oppramsobjekt' som kan brukes til å gjennomgå alle elementer i
	 * mengden etter tur en gang
	 * 
	 * @return et oppramsobjekt
	 */
	Iterator<T> iterate();

}
