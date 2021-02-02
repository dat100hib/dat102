package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;


public interface KoeADT<T>{
   
	/**
	 * Legge til et element bak i køen.
	 * @param element er elementet som blir satt inn i køen
	 */
    void innKoe (T element) ;

   
    /**
     * Fjerner og returnerer elementet foran i køen.
     * @return elementet foran i køen
     * @exception EmptyCollectionException unntak som kastes hvis køen er tom
     */
    
    T utKoe();

 
    /**
     * Returnerer elementet foran i køen uten å fjerne det fra køen.
     * @return elementet foran i køen
     * @exception EmptyCollectionException unntak kastes hvis køen allerede er tom
     */
    T foerste() ;
   
  
    /**
     * Returnerer sann hvis denne køen ikke inneholder noen elementer.
     * @return sann dersom køen er tom ellers usann
     */
    boolean erTom();

   
    /** 
     * Returnerer antall elementer i køen.
     * @return antall elementer i køen
     */
    int antall();
  
}//