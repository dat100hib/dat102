package no.hvl.dat102;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat102.Kalkulator;

public class TestKalkulator {
	//testmetoder

	@Test
	public void testAdd() {
		assertEquals("Test av 1+5", 6, Kalkulator.add(1, 5));
	}
	
	
	@Test
	public void testT() {
		assertFalse(Kalkulator.t());
	}

	@Test
	public void testSub() {
		assertEquals("Test av 4-2", 2, Kalkulator.sub(4, 2));
		assertEquals("Test av 2-4", -2, Kalkulator.sub(2, 4));

	}

	@Test
	public void testMul() {
		assertEquals("Test av 3*2", 6, Kalkulator.mul(3, 2));
	}

	@Test
	public void testDiv() {
		assertEquals("Test av 4/2", 2, Kalkulator.div(4, 2));
	}

}
