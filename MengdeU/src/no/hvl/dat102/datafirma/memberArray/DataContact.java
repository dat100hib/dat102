package no.hvl.dat102.datafirma.memberArray;

import no.hvl.dat102.datafirma.members.Medlem;
import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.tabell.ArraySet;

import java.util.Iterator;

public class DataContact {

    private SetADT<Medlem> memberArray;
    private int memberSum;

    public DataContact(SetADT<Medlem> memberArray)
    {
    this.memberArray = memberArray;
    memberSum = memberArray.antall();

    }

    public void addMember(Medlem medlem){
        memberArray.leggTil(medlem);
    }

    public int findMemberIndex(String memberName) {
        Iterator iterator = memberArray.iterate();

        for(Medlem test = (Medlem)iterator.next();iterator.hasNext();test = (Medlem)iterator.next() ) {
            if (test.getName().equals(memberName)) {
                return test.getStatusIndex();
            }
        }
    return -1;
    }

}
