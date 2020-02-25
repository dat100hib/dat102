package no.hvl.dat102.TabellOrdnetListeTest;


import no.hvl.dat102.adt.SetADTTest;
import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.tabell.ArraySet;

public class ArraySetTest extends SetADTTest {
	@Override
	protected SetADT<Integer> reset() {
		return new ArraySet<Integer>();
	}
}
