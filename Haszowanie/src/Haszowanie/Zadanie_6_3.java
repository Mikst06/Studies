package Haszowanie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Struktura{
    String nazwisko;
    int wartosc;
    Struktura(String nazwisko, int wartosc){
        this.nazwisko = nazwisko;
        this.wartosc = wartosc;
    }

    public String getNazwisko(){
        return nazwisko;
    }
    public int getWartosc(){
        return wartosc;
    }

}
public class Zadanie_6_3 {
    private static int Hash(Struktura strukt, long stala, int m, int i){
        long k = Haszowanie.Zadanie_6_2.Convert(strukt.getNazwisko(),stala,m);
        return (int) (((k%m) + i)%m);
    }
    public static int HashInsert(Struktura obiekt, Struktura[] tablicaHasz, long stala, int m){
        int i = 0;
        boolean warunek = true;
        do{
            int j = Hash(obiekt, stala, m, i);
            if(tablicaHasz[j]==null) {
                tablicaHasz[j] = new Struktura(obiekt.getNazwisko(), obiekt.getWartosc());
                warunek = false;
            }
            i++;
        }while(warunek&&(i<m));
        if(warunek){
            System.out.format("Brak miejsca dla nazwiska %s\n",obiekt.getNazwisko());
        }
        return i;
    }
    public static void Start(long stala, int m, int warunek) throws IOException {
        final int ILOSCNAZWISK = 3;
        BufferedReader read = new BufferedReader(new FileReader("nazwiska.txt"));
        String slowo;
        Struktura[] malaT = new Struktura[ILOSCNAZWISK];
        Struktura[] malaTHasz = new Struktura[m];
        for(int i = 0; ((slowo = read.readLine())!=null) && (i<ILOSCNAZWISK); i++){
            String[] w = slowo.split(" ");
            malaT[i] = new Struktura(w[1],Integer.parseInt(w[0]));
        }
        if(warunek == 0) {
            for (int i = 0; i < m; i++) {
                malaTHasz[i] = null;
            }
            for (int i = 0; i < ILOSCNAZWISK; i++) {
                HashInsert(malaT[i], malaTHasz, stala, m);
            }
            for (int i = 0; i < malaTHasz.length; i++) {
                if(malaTHasz[i]==null){System.out.println((String) null);}
                else {System.out.println(malaTHasz[i].getNazwisko());}
            }
        }
        int suma = 0;
        if(warunek == 50) {
            for(int z = 0; z < m/2; z++){
                HashInsert(malaT[z], malaTHasz, stala, m);
            }
            for(int z = 0; z < (5*m)/100; z++){
                suma+=HashInsert(malaT[z+(m/2)-1], malaTHasz, stala, m)-1;
            }
            System.out.format("Srednia liczba prob wstawienia elementu dla 50: %.2f\n",suma*1.0/((5*m)*1.0/100*1.0));
        }
        else if(warunek == 70) {
            for(int z = 0; z < (m*7)/10; z++){
                HashInsert(malaT[z], malaTHasz, stala, m);
            }
            for(int z = 0; z < (5*m)/100; z++){
                suma+=HashInsert(malaT[z+((5*m)/100)-1], malaTHasz, stala, m)-1;
            }
            System.out.format("Srednia liczba prob wstawienia elementu dla 70: %.2f\n",suma*1.0/((5*m)*1.0/100*1.0));
        }
        else if(warunek == 90) {
            for(int z = 0; z < (m*9)/10; z++){
                HashInsert(malaT[z], malaTHasz, stala, m);
            }
            for(int z = 0; z < (5*m)/100; z++){
                suma+=HashInsert(malaT[z+((9*m)/100)-1], malaTHasz, stala, m)-1;
            }
            System.out.format("Srednia liczba prob wstawienia elementu dla 90: %.2f\n",suma*1.0/((5*m)*1.0/100*1.0));
        }
    }
}
