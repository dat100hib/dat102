package no.hvl.dat102;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tester Karakter.
 * 
 * @Ole Olsen
 */
public class KarakterTest {

	@Test
	public void er100enA() throws FeilKarakterException {
		assertEquals("feil karakter", 'A', Karakter.beregnKarakter(100));
	}

	@Test
	public void er95enA() throws FeilKarakterException {
		assertEquals("feil karakter", 'A', Karakter.beregnKarakter(95));
	}

	@Test
	public void er90enA() throws FeilKarakterException {
		assertEquals("feil karakter", 'A', Karakter.beregnKarakter(90));
	}

	@Test
	public void er89enB() throws FeilKarakterException {
		assertEquals("feil karakter", 'B', Karakter.beregnKarakter(89));
	}

	@Test
	public void er82enB() throws FeilKarakterException {
		assertEquals("feil karakter", 'B', Karakter.beregnKarakter(82));
	}

	@Test
	public void er80enB() throws FeilKarakterException {
		assertEquals("feil karakter", 'B', Karakter.beregnKarakter(80));
	}

	@Test
	public void er79enC() throws FeilKarakterException {
		assertEquals("feil karakter", 'C', Karakter.beregnKarakter(79));
	}

	@Test
	public void er66enC() throws FeilKarakterException {
		assertEquals("feil karakter", 'C', Karakter.beregnKarakter(66));
	}

	@Test
	public void er60enC() throws FeilKarakterException {
		assertEquals("feil karakter", 'C', Karakter.beregnKarakter(60));
	}

	@Test
	public void er59enD() throws FeilKarakterException {
		assertEquals("feil karakter", 'D', Karakter.beregnKarakter(59));
	}

	@Test
	public void er54enD() throws FeilKarakterException {
		assertEquals("feil karakter", 'D', Karakter.beregnKarakter(54));
	}

	@Test
	public void er50enD() throws FeilKarakterException {
		assertEquals("feil karakter", 'D', Karakter.beregnKarakter(50));
	}

	@Test
	public void er49enE() throws FeilKarakterException {
		assertEquals("feil karakter", 'E', Karakter.beregnKarakter(49));
	}

	@Test
	public void er45enE() throws FeilKarakterException {
		assertEquals("feil karakter", 'E', Karakter.beregnKarakter(45));
	}

	@Test
	public void er40enE() throws FeilKarakterException {
		assertEquals("feil karakter", 'E', Karakter.beregnKarakter(40));
	}

	@Test
	public void er39enF() throws FeilKarakterException {
		assertEquals("feil karakter", 'F', Karakter.beregnKarakter(39));
	}

	@Test
	public void er37enF() throws FeilKarakterException {
		assertEquals("feil karakter", 'F', Karakter.beregnKarakter(37));
	}

	@Test
	public void er0enF() throws FeilKarakterException {
		assertEquals("feil karakter", 'F', Karakter.beregnKarakter(0));
	}

	@Test(expected = FeilKarakterException.class)
	// Forventer at metoden skal kaste unntaket for at testen skal være riktig.
	public void er101ulovlig() throws FeilKarakterException {
		Karakter.beregnKarakter(101);
	}

	// ... Samme her
	@Test(expected = FeilKarakterException.class)
	public void erNegativUlovlig() throws FeilKarakterException {
		Karakter.beregnKarakter(-1);
	}

}
