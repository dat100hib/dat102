package no.hvl.dat102;
//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen når samlingen er tom
//********************************************************************
public class EmptyCollectionException extends RuntimeException{
   /******************************************************************
     Setter opp et unntak med passende melding.
   ******************************************************************/
   public EmptyCollectionException (String samling) {
      super ("" + samling + " er tom.");
   }
}
