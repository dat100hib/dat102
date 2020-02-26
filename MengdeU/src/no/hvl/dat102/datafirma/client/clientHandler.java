package no.hvl.dat102.datafirma.client;

import no.hvl.dat102.datafirma.memberArray.DataContact;
import no.hvl.dat102.datafirma.members.Hobby;
import no.hvl.dat102.datafirma.members.Medlem;
import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;
import no.hvl.dat102.mengde.tabell.ArraySet;

public class clientHandler {

    public static void main(String[] args) {


        SetADT<Medlem> medlemer = new ArraySet<Medlem>();

        SetADT<Hobby> egilsHobby = new LinkedSet<Hobby>();
        Hobby sykle = new Hobby("Sykle");
        Hobby ski = new Hobby("Ski");
        egilsHobby.leggTil(sykle);
        egilsHobby.leggTil(ski);
        Medlem egil = new Medlem("Egil", egilsHobby,0 );
        Medlem egiline = new Medlem("Egiline", egilsHobby,2 );

        DataContact data = new DataContact(new Medlem[0]);
       data.addMember(egil);
       data.addMember(egiline);
        System.out.println(data.findMemberIndex("Egil"));
        System.out.println(data.findMemberIndex("Egiline"));

        egilsHobby.leggTil(sykle);






        System.out.println(egil);
        System.out.println(egilsHobby);



    }
}
