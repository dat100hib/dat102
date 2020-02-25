package no.hvl.dat102.mengde.klient;
import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;
import no.hvl.dat102.mengde.tabell.ArraySet;

public class SwapClass<T> {



    public static int x =0;


    @SuppressWarnings("unchecked")
    public static SetADT retrieveClass() {
        SetADT obj=null;
        if(x==1) {
           obj = new ArraySet<>();
        } else {
            obj = new LinkedSet<>();
        }

        return obj;
    }

    public static void setX(int x) {
        SwapClass.x = x;
    }



}
