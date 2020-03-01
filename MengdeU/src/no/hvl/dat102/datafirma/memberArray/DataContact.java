package no.hvl.dat102.datafirma.memberArray;

import no.hvl.dat102.datafirma.members.Medlem;
import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.tabell.ArraySet;

import java.util.Iterator;

public class DataContact {

    private Medlem[] memberArray;
    private int memberSum;
    private int coupleSum;
    public DataContact(Medlem[] memberArray)
    {
    this.memberArray = memberArray;
    memberSum = 0;

    }

    /**
     *
     * @param medlem
     */
    public void addMember(Medlem medlem){
        memberArray[memberSum]= medlem;
        memberSum++;
        findPartnerFor(memberArray[memberSum-1].getName());

    }

    /**
     * Takes a string, searches for matches of said string, in member database.
     * @param memberName
     * @return  returns index of member. -1 if none found.
     */
    public int findMemberIndex(String memberName) {
        for(int i =0; i<memberSum; i++){
            if(memberArray[i].getName().equals(memberName)){
                return i;
            }
        }
    return -1;
    }

    /**
     * Takes a string, finds member with findMemberIndex().
     * @param memberName
     * @return
     */
    public int findPartnerFor(String memberName){
        // Check to see if member exists.
        if(findMemberIndex(memberName)==-1){
            return -1;
        }
        // lonley member
        Medlem whoAmI = memberArray[findMemberIndex(memberName)];
        // Check if whoAmI is connected, mormon connect not allowed.
        if(whoAmI.getStatusIndex()!=-1){
            return whoAmI.getStatusIndex();
        }

        for(int loveScan = 0; loveScan < memberSum;loveScan ++ ) {
            // Check self not self & check self is not connected & can the self connect and make wet in the warm?
            if(!whoAmI.equals(memberArray[loveScan]) && whoAmI.getStatusIndex()==-1 && whoAmI.passerTil(memberArray[loveScan]) ){
                // If lonely member found partner who does not already have a partner, get matched and update.
                // polygamy NOT allowed!
                whoAmI.setStatusIndex(loveScan);
                memberArray[loveScan].setStatusIndex(findMemberIndex(memberName));
                coupleSum++;
                return memberArray[loveScan].getStatusIndex();
            }
        }
        // If lonely member exist but has match continue solitude and return defeated.
        return -1;
}

public void breakUpReset(String memberName){
        // if member has no partner return
        if(findPartnerFor(memberName)== -1){
            return;
        }

        memberArray[findPartnerFor(memberName)].setStatusIndex(-1);
        memberArray[findMemberIndex(memberName)].setStatusIndex(-1);
        coupleSum--;
}

    public int getMemberSum() {
        return memberSum;
    }

    public int getCoupleSum() {
        return coupleSum;
    }

    public Medlem[] getMemberArray() {
        return memberArray;
    }
}
