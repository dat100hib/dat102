package no.hvl.dat102;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestKalkulator {
	//testmetoder
 
	@Test
	public void testAdd() {
		assertEquals(3, Kalkulator.add(1, 2),"Test av 1+2");
	}

	@Test
	public void testSub() {
		assertEquals(2, Kalkulator.sub(4, 2),"Test av 4-2");
		assertEquals(-2, Kalkulator.sub(2, 4),"Test av 2-4");

	}

	@Test
	public void testMul() {
		assertEquals( 6, Kalkulator.mul(3, 2),"Test av 3*2");
	}

	@Test
	public void testDiv() {
		assertEquals(2, Kalkulator.div(4, 2),"Test av 4/2");
	}

}
