package no.hvl.dat102.linkedTest;

import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.adt.SetADTTest;
import no.hvl.dat102.mengde.kjedet.LinkedSet;



public class LinkedSetTest extends SetADTTest {
	   @Override
		protected SetADT<Integer> reset() {
			return new LinkedSet<>();
		}		
}

