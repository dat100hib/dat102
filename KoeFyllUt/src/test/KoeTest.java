package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADT;

public class KoeTest<T> {
	private KoeADT<Integer> Koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected KoeADT<Integer> reset() {
		return Koe;
	}

	/**
	 * Hent en ny kø for hver test.
	 * 
	 * @return
	 */
	
	@BeforeEach
	public void setup() {
		Koe = reset();
	}
	
	@Test
	void innOgUtKoe() {
		Koe.innKoe(e0);
		Koe.innKoe(e1);
		Koe.innKoe(e2);
		Koe.innKoe(e3);
		Koe.innKoe(e4);
		assertEquals(e0, Koe.utKoe());
		assertEquals(e1, Koe.utKoe());
		assertEquals(e2, Koe.utKoe());
		assertEquals(e3, Koe.utKoe());
		assertEquals(e4, Koe.utKoe());
	}
	
	@Test
	T foerste() {
		assertEquals(e0, Koe.foerste());
		return (T) Koe.foerste();	
	}
	
	@Test
	boolean erTom() {
		assertTrue(Koe.erTom());
		return Koe.erTom();
	}
	
	@Test
	int antall() {
		return e0+e1+e2+e3+e4;
	}
	
}