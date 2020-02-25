package no.hvl.dat102.datafirma.client;

import no.hvl.dat102.datafirma.members.Hobby;
import no.hvl.dat102.datafirma.members.Medlem;
import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;

public class clientHandler {

    public static void main(String[] args) {
        SetADT<Hobby> egilsHobby = new LinkedSet<Hobby>();
        Hobby sykle = new Hobby("Sykle");
        Hobby ski = new Hobby("Ski");

        egilsHobby.leggTil(sykle);

        egilsHobby.leggTil(sykle);


        egilsHobby.leggTil(ski);

        Medlem egil = new Medlem("Egil", egilsHobby,0 );


        System.out.println(egil);
        System.out.println(egilsHobby);


    }
}
