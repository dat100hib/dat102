package test;

import no.hvl.dat102.adt.KoeADT;
import no.dat102.tabell.TabellKoe;
import test.KoeTest;

public class TabellKoeTest<T> extends KoeTest<T> {
	@Override
	protected KoeADT<Integer> reset() {
		return new TabellKoe<Integer>();
	}
	
}
