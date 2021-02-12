import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.kjedet.*;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.sirkulaer.*;
import no.hvl.dat102.exception.*;
import no.dat102.tabell.*;

class Koetests {

	
		private KoeADT<Integer> Koe;
		private KoeADT<Integer> Koe2;
		private KoeADT<Integer> Koe3;

		// Testdata
		private Integer e0 = 1;
		private Integer e1 = 2;
	

		@BeforeEach
		public final void setup() {
			Koe = new TabellKoe<Integer>();
			Koe2 = new SirkulaerKoe<Integer>();
			Koe3 = new KjedetKoe<Integer>();
		}

		@Test
		public final void nyKoeErTom() {
			assertTrue(Koe.erTom());
			assertTrue(Koe2.erTom());
			assertTrue(Koe3.erTom());
			
		}

		//testing if innkoe works at all
		@Test
		public final void erIkkeTom() {
			Koe.innKoe(e0);
			Koe.innKoe(e1);
			
			Koe2.innKoe(e0);
			Koe2.innKoe(e1);
			
			Koe3.innKoe(e0);
			Koe3.innKoe(e1);
			
			assertFalse(Koe.erTom());
			assertFalse(Koe2.erTom());
			assertFalse(Koe3.erTom());
		}

		//testing if the size of the queue is reflective of the number of entries/does innkoe work across several inputs
		@Test
		public final void stor() {
			Koe.innKoe(e0);
			Koe.innKoe(e1);
			
			Koe2.innKoe(e0);
			Koe2.innKoe(e1);
			
			Koe3.innKoe(e0);
			Koe3.innKoe(e1);
			
			assertEquals(2, Koe.antall());
			assertEquals(2, Koe2.antall());
			assertEquals(2, Koe3.antall());
		}

		// testing if innkoe sets the element in the end of the queue
		@Test
		public final void erSiste() {
			Koe.innKoe(e0);
			Koe.innKoe(e1);
			
			
			Koe2.innKoe(e0);
			Koe2.innKoe(e1);
			
			Koe3.innKoe(e0);
			Koe3.innKoe(e1);
			
			assertTrue(Koe.foerste() == e0);
			assertTrue(Koe2.foerste() == e0);
			assertTrue(Koe3.foerste() == e0);
		}
		
		//Does utkoe work
		@Test
		public final void erKastet() {
			Koe.innKoe(e0);
			Koe.innKoe(e1);
			Koe.utKoe();
			
			
			Koe2.innKoe(e0);
			Koe2.innKoe(e1);
			Koe2.utKoe();
			
			Koe3.innKoe(e0);
			Koe3.innKoe(e1);
			Koe3.utKoe();

			
			assertTrue(Koe.foerste() == e1);
			assertTrue(Koe2.foerste() == e1);
			assertTrue(Koe3.foerste() == e1);
			
		}

	}


