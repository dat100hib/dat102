package no.hvl.dat102.datafirma.members;

import no.hvl.dat102.mengde.adt.SetADT;
import no.hvl.dat102.mengde.kjedet.LinkedSet;

public class Medlem {


        private String name;
        private SetADT<Hobby> hobbies;
        private int statusIndex;

        public Medlem(){
            name="";
            hobbies = new LinkedSet<Hobby>();
            statusIndex=-1;
        }
    public Medlem(String name){
        this.name=name;
        hobbies = new LinkedSet<Hobby>();
        statusIndex=-1;
    }
        public Medlem(String name,SetADT<Hobby> hobbies, int index){
            this.name = name;
            this.hobbies = hobbies;
            statusIndex = index;
            }


    public boolean passerTil(Medlem another){
            return(this.getHobbies().equals(another.getHobbies()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public SetADT<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(SetADT<Hobby> hobbies) {
        this.hobbies = hobbies;
    }


    public int getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(int statusIndex) {
        this.statusIndex = statusIndex;
    }
}
