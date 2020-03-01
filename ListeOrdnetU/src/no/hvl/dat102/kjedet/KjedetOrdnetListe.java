package no.hvl.dat102.kjedet;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.*;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> firstNode, lastNode;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		firstNode = null;
		lastNode = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		// ...Fyll ut
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		// ...Fyll ut
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = firstNode.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = lastNode.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		LinearNode<T> newNode = new LinearNode<>(element),  current = firstNode;

		// special cases: empty list, first or last
		if(antall==0){
			firstNode = lastNode = newNode;
			} else if(firstNode.getElement().compareTo(element) >-1){
			newNode.setNeste(current);
			firstNode = newNode;
		} else if(lastNode.getElement().compareTo(element)< 1){
			lastNode.setNeste(newNode);
			lastNode = newNode;
		} else{
			// finding placement in middle
			while (current.getNeste().getElement().compareTo(element) > 0)
				current = current.getNeste();
			newNode.setNeste(current.getNeste());
			current.setNeste(newNode);
		}
			antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = firstNode;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				firstNode = firstNode.getNeste();
				if (firstNode == null) { // Tom liste
					lastNode = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == lastNode) { // bak
					lastNode = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = firstNode;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
