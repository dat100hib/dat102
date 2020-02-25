package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public class ArraySet<T> implements SetADT<T> {
    // ADT-en Mengde implementert som tabell
    //
    private final static Random tilf = new Random();
    private final static int STDK = 100;
    private int antall;
    private T[] tab;

    public ArraySet() {
        this(STDK);
    }

    public ArraySet(int start) {
        antall = 0;
        tab = (T[]) (new Object[start]);
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean erTom() {
        return (antall == 0);
    }

    @Override
    public void leggTil(T element) {
        if (!hasThis(element)) {
            if (antall == tab.length) {
                utvidKapasitet();
            }
            tab[antall] = element;
            antall++;
        }
    }

    private void utvidKapasitet() {
        T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
        for (int i = 0; i < tab.length; i++) {
            hjelpetabell[i] = tab[i];
        }
        tab = hjelpetabell;
    }

    @Override
    public T fjernTilfeldig() {
        if (erTom())
            throw new EmptyCollectionException("mengde");

        T svar = null;
        int indeks = tilf.nextInt(antall);
        svar = tab[indeks];
        tab[indeks] = tab[antall - 1];
        antall--;

        return svar;
    }

    @Override
    public T fjern(T element) {
        // Søker etter og fjerner element. Returnerer null-ref ved ikke-funn

        if (erTom())
            throw new EmptyCollectionException("mengde");


        T removed = null;

        // Check if first
        for (int scan = 0; scan < antall; antall++) {
            if (tab[scan].equals(element)) {
                removed = tab[scan];
                tab[scan] = tab[antall - 1];
                T[] kopi = (T[]) (new Object[antall - 1]);
                for (int i = 0; i < kopi.length; i++) {
                    kopi[i] = tab[i];
                }
                tab = kopi;
                antall--;
                break;
            }

        }

        return removed;
    }

    @Override
    public boolean hasThis(T element) {
        for (int i = 0; (i < antall); i++)
            if (tab[i].equals(element)) return true;
        return false;
    }

    @Override
    public boolean equals(Object m2) {
        boolean provenEqual=false;
        T element;

        ArraySet<T> refArray = (ArraySet<T>) m2;

        T[]m3 = refArray.tab;

        // Check if size missmatch
        if (antall != refArray.antall)
            return false;

        // considered a different approach where once an element of m3 has been matched
        // to an element in this it would be removed for future comparison.
        // However doing some quick maths I came to the realization that
        // the 0.5n*n is still n^2

        for (int scan = 0; scan < antall; scan++) {
            provenEqual=false;
        	for (int innerScan = 0; innerScan < antall; innerScan++) {
                if (tab[scan].equals(m3[innerScan])) {
                    provenEqual = true;

                }
            }
            // If an element had no equal he is unique without equal
            if(!provenEqual){
			return  false;
			}


        }


        return provenEqual;
    }

    @Override
    public void addAll(SetADT<T> m2) {
        Iterator<T> teller = m2.iterate();
        while (teller.hasNext())
            leggTil(teller.next());
    }

    /*
     * Denne versjonen av unionen er lite effekktiv
     *
     * @Override public MengdeADT<T> union(MengdeADT<T> m2) { TabellMengde<T> begge
     * = new TabellMengde<T>(); for (int i = 0; i < antall; i++) {
     * begge.leggTil(tab[i]); } Iterator<T> teller = m2.oppramser();
     *
     * while (teller.hasNext()) { begge.leggTil(teller.next()); } return
     * (MengdeADT<T>)begge; }
     */
    @Override

    public SetADT<T> union(SetADT<T> m2) {
        SetADT<T> both = new ArraySet<T>();
        T element = null;
        both.addAll(this);
        Iterator<T> iterator = m2.iterate();
        while(iterator.hasNext())
        {
            element = iterator.next();
            if(!both.hasThis(element)){
                ((ArraySet<T>)both).settInn(element);
            }

        }
        return both;
    }//

    @Override
    public SetADT<T> intersection(SetADT<T> m2) {
        SetADT<T> sharedSet = new ArraySet<T>();
        T element = null;

        Iterator<T> iterator = m2.iterate();
        while(iterator.hasNext()){
            element = iterator.next();
            if(this.hasThis(element)){
                ((ArraySet<T>)sharedSet).settInn(element);
            }

        }
        return sharedSet;
    }

    @Override
    public SetADT<T> difference(SetADT<T> m2) {
        SetADT<T> diffSet = new ArraySet<T>();
        T element = null;

        Iterator<T> iterator = this.iterate();
        while(iterator.hasNext()){
            element = iterator.next();
            if(!m2.hasThis(element)){

                ((ArraySet<T>)diffSet).settInn(element);
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
        return new TabellIterator<T>(tab, antall);
    }

    private void settInn(T element) {
        if (antall == tab.length) {
            utvidKapasitet();
        }
        tab[antall] = element;
        antall++;
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
