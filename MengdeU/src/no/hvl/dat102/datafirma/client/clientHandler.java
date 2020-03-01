package no.hvl.dat102.datafirma.client;

import no.hvl.dat102.datafirma.memberArray.DataContact;
import no.hvl.dat102.datafirma.members.Hobby;
import no.hvl.dat102.datafirma.members.Medlem;
import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;
import no.hvl.dat102.mengde.tabell.ArraySet;

import java.util.Scanner;

public class clientHandler {

    public static void main(String[] args) {


        Medlem erna = new Medlem("Erna");
        Medlem jonas = new Medlem("Jonas" );
        Medlem eva = new Medlem("Eva");
        Medlem adam = new Medlem("Adam");


        SetADT<Hobby> ernaHobby = new LinkedSet<Hobby>();
        SetADT<Hobby> jonasHobby = new LinkedSet<Hobby>();
        SetADT<Hobby> evaHobby = new LinkedSet<Hobby>();
        SetADT<Hobby> adamHobby = new LinkedSet<Hobby>();



        ernaHobby.leggTil(new Hobby("musikk"));
        ernaHobby.leggTil(new Hobby("ski"));
        ernaHobby.leggTil(new Hobby("politikk"));
        jonasHobby.leggTil(new Hobby("politikk"));
        jonasHobby.leggTil(new Hobby("ski"));
        jonasHobby.leggTil(new Hobby("musikk"));

        evaHobby.leggTil(new Hobby("epleplukking"));
        evaHobby.leggTil(new Hobby("paradishopping"));
        adamHobby.leggTil(new Hobby("epleplukking"));
        adamHobby.leggTil(new Hobby("paradishopping"));


        erna.setHobbies(ernaHobby);
        eva.setHobbies(evaHobby);
        jonas.setHobbies(jonasHobby);
        adam.setHobbies(adamHobby);

        DataContact data = new DataContact(new Medlem[10]);
       data.addMember(erna);
       data.addMember(jonas);
       data.addMember(eva);
       data.addMember(adam);
        data.findPartnerFor("Erna");
        data.findPartnerFor("Adam");


        TextUI.printConnectedMembers(data);

        data.breakUpReset("Erna");
        TextUI.printConnectedMembers(data);

        TextUI.run(data);
        TextUI.printConnectedMembers(data);

        System.out.println(erna);
        System.out.println(ernaHobby);



    }



}
