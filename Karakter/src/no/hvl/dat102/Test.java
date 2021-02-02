package no.hvl.dat102;

public class Test {
	
	public static void tid(long n) {
		long k= 0;
		for(long i= 1; i <= n; i++) {
			k= k + 5;
			}
		System.out.println(k);
	}

	public static void main(String[] args) {
		tid(100000000L);
		tid(1000000000L);
		tid(10000000000L);

	}

}
