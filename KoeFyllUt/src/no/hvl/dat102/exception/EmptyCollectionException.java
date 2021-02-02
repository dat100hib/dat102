package no.hvl.dat102.exception;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen når samlingen er tom.
//********************************************************************

public class EmptyCollectionException extends RuntimeException{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/******************************************************************
     Setter opp dette unntaket med passende melding.
   ******************************************************************/
   public EmptyCollectionException (String samling){
      super (" Denne " + samling + " er tom.");
   }
}
