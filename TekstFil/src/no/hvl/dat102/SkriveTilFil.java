package no.hvl.dat102;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SkriveTilFil {
    
    public static void main(String[] args) {
        
        final String SKILLE = ":";                // parameter når vi lager metode
        final String ANSATT_FIL = ""; // parameter når vi lager metode
        
        Ansatt anne = new Ansatt("Anne", "Dahl", 220, Ansatt.KVINNE);
        Ansatt knut = new Ansatt("Knut", "Olsen", 180, Ansatt.MANN);
        int antall = 2; 
        
        try {
            // 1 - FileWriter
            FileWriter ansFil = new FileWriter(ANSATT_FIL, false);
            
            // 2 - PrintWriter
            PrintWriter utfil = new PrintWriter(ansFil);
            
            //3 - Skriver først ut antall ansatt-info-er på den første linjen            
            utfil.println(antall);
            
            // Hvis vi tar imot en tabell av ansatte, ville vi her lage en løkke der
            // vi for hver ansatt henter ut feltvariable og skriver de ut på samme linje
            
            // 3 - Skriv postene, felt for felt
            utfil.print(anne.getFornavn()); utfil.print(SKILLE);
            utfil.print(anne.getEtternavn()); utfil.print(SKILLE);
            utfil.print(anne.getTimeloenn()); utfil.print(SKILLE);
            utfil.print(anne.isKjoenn()); utfil.println();
            
            utfil.print(knut.getFornavn()); utfil.print(SKILLE);
            utfil.print(knut.getEtternavn()); utfil.print(SKILLE);
            utfil.print(knut.getTimeloenn()); utfil.print(SKILLE);
            utfil.print(knut.isKjoenn()); utfil.println();
            
            // 4 - Lukk filen
            utfil.close();
            
        } catch (IOException e) {
            System.out.println("Feil ved skriving til fil : " + e);
            System.exit(3);
        }
    }
}