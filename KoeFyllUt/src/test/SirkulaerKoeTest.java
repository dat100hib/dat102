package test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;
import test.KoeTest;

public class SirkulaerKoeTest<T> extends KoeTest<T> {
	@Override
	protected KoeADT<Integer> reset() {
		return new SirkulaerKoe<Integer>();
	}
	

}
