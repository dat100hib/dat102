package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import no.hvl.dat102.exception.EmptyCollectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import no.hvl.dat102.mengde.adt.SetADT;


public abstract class SetADTTest {

	/**
	 * Test av OrdnetListe med heltall.
	 *
	 * @author
	 */

	private SetADT<Integer> integerSet1;
	private SetADT<Integer> integerSet2;

	// Test data
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;
	private Integer e7 = 8;
	private Integer e8 = 9;

	private SetADT<String> stringSet;


	/**
	 * Opprett en tom liste for hver test.
	 */

	protected abstract SetADT<Integer> reset();

	@BeforeEach
	public final void setup() {
		integerSet1 = reset();
		integerSet2 = reset();
	}

	/**
	 * Tester om en ny liste er tom.
	 */


	@Test
	public final void unionUniqueSets() {
		// Asserts that the union of two empty sets are indeed empty
		assertTrue((integerSet1.union(integerSet2)).erTom());


		integerSet1.leggTil(e0);
		integerSet1.leggTil(e1);
		integerSet1.leggTil(e2);
		integerSet1.leggTil(e3);
		integerSet1.leggTil(e4);
		// Asserts that the union of an empty sets and a non empty set equals  the non empty set.
		assertTrue(integerSet1.equals(integerSet1.union(integerSet2)));

		integerSet2.leggTil(e5);
		integerSet2.leggTil(e6);
		integerSet2.leggTil(e7);
		integerSet2.leggTil(e8);
		SetADT<Integer> both;
		assertFalse(integerSet1.equals(integerSet1.union(integerSet2)));
		both = integerSet1.union(integerSet2);
		SetADT<Integer> compareBoth = reset();
		for (int i = 0; i < 9; i++) {
			compareBoth.leggTil((Integer) i + 1);
		}
		assertTrue(both.equals(compareBoth));
	}

	@Test
	public final void unionSharedElements() {

		integerSet1.leggTil(e0);
		integerSet1.leggTil(e1);
		integerSet1.leggTil(e2);
		integerSet1.leggTil(e3);
		integerSet1.leggTil(e4);

		integerSet2.leggTil(e0);
		integerSet2.leggTil(e1);
		integerSet2.leggTil(e7);
		integerSet2.leggTil(e6);
		integerSet2.leggTil(e5);

		assertEquals(8,integerSet1.union(integerSet2).antall());


		integerSet1.leggTil(e7);
		integerSet1.leggTil(e6);
		integerSet1.leggTil(e5);

		assertTrue(integerSet1.equals(integerSet2.union(integerSet1)));





	}

	@Test
	public final void interJoint() {
		integerSet1.leggTil(e0);
		integerSet1.leggTil(e1);
		integerSet1.leggTil(e2);
		integerSet1.leggTil(e3);
		integerSet1.leggTil(e4);

		integerSet2.leggTil(e0);
		integerSet2.leggTil(e1);
		integerSet2.leggTil(e7);
		integerSet2.leggTil(e6);
		integerSet2.leggTil(e5);

		assertTrue(integerSet1.subSet(integerSet1.intersection(integerSet2)));
		assertTrue(integerSet1.subSet(integerSet1.intersection(integerSet2)));
		assertEquals(2, integerSet1.intersection(integerSet2).antall());
		integerSet1.leggTil(e8);
		integerSet2.leggTil(e8);
		assertNotEquals(2, integerSet1.intersection(integerSet2).antall());
		assertEquals(3, integerSet1.intersection(integerSet2).antall());
		assertTrue(integerSet1.intersection(integerSet2).hasThis(e8));
	}

	@Test
	public final void interDisjoint() {
		integerSet1.leggTil(e0);
		integerSet1.leggTil(e1);
		integerSet1.leggTil(e2);
		integerSet1.leggTil(e3);
		integerSet1.leggTil(e4);


		integerSet2.leggTil(e8);
		integerSet2.leggTil(e7);
		integerSet2.leggTil(e6);
		integerSet2.leggTil(e5);
	assertEquals(0, integerSet1.intersection(integerSet2).antall());
		integerSet2.leggTil(e4);
		SetADT<Integer> both= integerSet1.intersection(integerSet2);
		both.fjern(e4);

		assertTrue(both.erTom());

	}

	@Test
	public final void diffJoint() {
		integerSet1.leggTil(e0);
		integerSet1.leggTil(e1);
		integerSet1.leggTil(e2);
		integerSet1.leggTil(e3);
		integerSet1.leggTil(e4);

		integerSet2.leggTil(e0);
		integerSet2.leggTil(e1);
		integerSet2.leggTil(e7);
		integerSet2.leggTil(e6);
		integerSet2.leggTil(e5);
		SetADT<Integer> diff = reset();

		diff.leggTil(e2);
		diff.leggTil(e3);
		diff.leggTil(e4);

		assertTrue(integerSet1.difference(integerSet2).equals(diff));


	}



	@Test
	public final void diffDisjoint() {

		integerSet1.leggTil(e0);
		integerSet1.leggTil(e1);
		integerSet1.leggTil(e2);
		integerSet1.leggTil(e3);
		integerSet1.leggTil(e4);


		integerSet2.leggTil(e8);
		integerSet2.leggTil(e7);
		integerSet2.leggTil(e6);
		integerSet2.leggTil(e5);
		assertTrue(integerSet1.difference(integerSet2).equals(integerSet1));
	}

}