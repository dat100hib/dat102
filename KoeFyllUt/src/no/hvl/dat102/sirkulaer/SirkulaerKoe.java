/**
 * 
 */
package no.hvl.dat102.sirkulaer;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;
/**
 * @author Ole Olsen
 * @param <T>
 * 
 */
public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int foran, bak, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		foran = bak = antall = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}

	public void innKoe(T element) {
		
		koe[bak] = element;
		antall++;
		
		
	}

	public T utKoe()  {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}else {
		
		T resultat = koe[0];
		bak--;
		
		for (int i = 0; i < bak; i++) {
			koe[i] = koe[i + 1];
		}
		
		koe[foran] = null;
		return resultat;
		}
	}

	public T foerste()  {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}else {
		
		T resultat = koe[0];
		return resultat;
	}
	}		

	public boolean erTom() {
		boolean result = false;
		if (antall == 0) {
			result = true;
		}
		return result;
	}
		

	public int antall() {
		return antall;
	}

	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		
		for (int soek = 0; soek < koe.length; soek++) {
			hjelpetabell[soek] = koe[soek];
		}

		koe = hjelpetabell;
	}

}
// class

		
	

