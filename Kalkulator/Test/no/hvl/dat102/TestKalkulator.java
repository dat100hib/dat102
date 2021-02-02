<<<<<<< HEAD
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
=======
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
>>>>>>> branch 'master' of https://github.com/587851/dat102.git
