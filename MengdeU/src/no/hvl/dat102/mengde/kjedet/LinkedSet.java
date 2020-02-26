package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public class LinkedSet<T> implements SetADT<T> {
	private static Random rand = new Random();
	private int size; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public LinkedSet() {
		size = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(hasThis(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			size++;
		}
	}

	@Override
	public void addAll(SetADT<T> m2) {
		Iterator<T> teller = m2.iterate();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(size) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		size--;

		return resultat;

	}//

	@Override
	public T fjern(T element) {
		if (erTom())
			throw new EmptyCollectionException("mengde");
		LinearNode<T> previous, current = previous = start;


		for (int scan = 0; scan < size; scan++) {
			if (current.getElement().equals(element)) {
				T result = current.getElement();
				previous.setNeste(current.getNeste());
				size--;
				return result;
			} else {
				previous = current;
				current = current.getNeste();
			}
		}


		return null;
	}//

	@Override
	public boolean hasThis(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < size && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(Object m2) {
		if (size != ((LinkedSet<T>) m2).size) return false;
		for (Iterator i = ((LinkedSet<T>) m2).iterate(); i.hasNext(); )
			if (!this.hasThis((T) i.next())) return false;
		return true;
	}


	@Override
	public boolean erTom() {
		return size == 0;
	}

	@Override
	public int antall() {
		return size;
	}

	@Override
	public SetADT<T> union(SetADT<T> m2) {
		SetADT<T> both = (new LinkedSet<T>());
		T element = null;

		both.addAll(this);
		Iterator<T> iterator = m2.iterate();
		while(iterator.hasNext()) {
		element = iterator.next();
			if (!both.hasThis(element)) {
				((LinkedSet<T>)both).settInn(element);
			}
		}
		return both;
	}//

	@Override
	public SetADT<T> intersection(SetADT<T> m2) {
		SetADT<T> sharedSet = new LinkedSet<T>();

		T element = null;

		Iterator<T> iterator = m2.iterate();
		while(iterator.hasNext()) {
			element = iterator.next();
			if (this.hasThis(element)) {
				((LinkedSet<T>)sharedSet).settInn(element);
			}
		}
		return sharedSet;
	}

	@Override
	public SetADT<T> difference(SetADT<T> m2) {
		SetADT<T> diffSet = new LinkedSet<T>();
		T element = null;

		Iterator<T> iterator = this.iterate();
		while(iterator.hasNext()) {
			element = iterator.next();
			if (!m2.hasThis(element)) {
				((LinkedSet<T>)diffSet).settInn(element);
			}
		}
		return diffSet;
	}

	@Override
	public boolean subSet(SetADT<T> m2) {
		return m2.difference(this).erTom();
	}

	@Override
	public Iterator<T> iterate() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		size++;
	}
	@Override
	public String toString(){
		StringBuilder strBuilder = new StringBuilder();
		Iterator<T> iterator = this.iterate();
		while(iterator.hasNext()){
			strBuilder.append(iterator.next().toString());
			if(iterator.hasNext()){
				strBuilder.append(", ");
			}
		}
		return "<"+strBuilder.toString()+">";

	}
}// class
