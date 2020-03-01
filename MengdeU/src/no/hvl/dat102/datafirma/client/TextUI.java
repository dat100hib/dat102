package no.hvl.dat102.datafirma.client;

import no.hvl.dat102.datafirma.memberArray.DataContact;
import no.hvl.dat102.datafirma.members.Hobby;
import no.hvl.dat102.datafirma.members.Medlem;
import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;


import java.util.Scanner;

public class TextUI {



    public static Medlem readMember(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Member:");
        String memberName = input.nextLine();
    Medlem newGuy =  new Medlem(memberName);
    String hobby= "";

    while(!hobby.equals("zzz")){
        System.out.println("Please enter " + memberName+"'s hobbies, enter 'zzz' to finish. ");
        hobby= input.nextLine();
        (newGuy.getHobbies()).leggTil(new Hobby(hobby));
    }

return newGuy;
}


public static void printHobbies(Medlem member){
    System.out.println(member.getName()+"'s hobbies: \n" + member.getHobbies().toString());
}


public static void printConnectedMembers(DataContact archive){
    System.out.printf("%-20s %s %n","Couples:" , "Hobbies:");
    Medlem[] search = archive.getMemberArray();
    for(int i = 0; i<archive.getMemberSum(); i++){
        if(search[i].getStatusIndex()>i){
              System.out.printf("%-20s %s %n", search[i].getName()+" and "+ search[search[i].getStatusIndex()].getName() , search[i].getHobbies().toString());
        }

    }
    System.out.println("Amount of couples: " +archive.getCoupleSum());




}


public static void run(DataContact archive){

    Scanner input = new Scanner(System.in);
    String  str="";
    while(!str.equals("zzz")) {


        archive.addMember(TextUI.readMember());
        System.out.println("Add another member? Cancel with zzz");
        str = input.nextLine();

    }


}

}
