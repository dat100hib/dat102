package no.hvl.dat102.datafirma.members;

public class Hobby {

    public String getHobbyName() {
        return hobbyName;
    }

    private String hobbyName;
    public Hobby(String hobby){
        hobbyName = hobby;
    }
    public String toString(){
return hobbyName;
    }

public boolean equals(Object checkHobby){
        return hobbyName.equals(((Hobby)checkHobby).getHobbyName());
}

}
