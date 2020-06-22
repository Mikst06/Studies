package wzorce;
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        int wiersz = 1;
        int index = 1;
        File file = new File("tekst.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int st;
        List<Triple> T = new ArrayList<>();
        while ((st = br.read()) != -1) {
            if(st!=13 && st !=10)
            {
                T.add(new Triple((char) st,wiersz,index));
                index++;
            }
            else if(st==10)
            {
                wiersz++;
                index=1;
            }
        }

        file = new File("wzorzec.txt");
        br = new BufferedReader(new FileReader(file));
        List<Character> P = new ArrayList<>();
        while ((st = br.read()) != -1) {
            if(st!=13 && st !=10)
            {
                P.add((char) st);
            }
        }

        long time1;
        long time2;
        double wynik = 0.0;

        final int iloscWykonan = 5000;

        System.out.println("NAIWNY");
        naiwnyFunkcja.naiwny(P, T, true);
        for (int i = 1; i <= iloscWykonan; i++) {

            time1 = System.nanoTime();
            naiwnyFunkcja.naiwny(P, T, false);
            time2 = System.nanoTime();

            wynik+= (time2-time1);

            if(i==iloscWykonan)
            {
                wynik = wynik/iloscWykonan;
                System.out.println("Średni czas wykonania: " + (wynik)/1000000 + " ms");
            }

        }
        System.out.print("\n");
        System.out.println("Rabin-Karp");
        RabinKarpFunkcja.RabinKarp(P, T, 128, 95027, true);
        wynik = 0.0;
        for (int i = 1; i <= iloscWykonan; i++) {

            time1 = System.nanoTime();
            RabinKarpFunkcja.RabinKarp(P, T, 128, 95027, false);
            time2 = System.nanoTime();

            wynik+= (time2-time1);

            if(i==iloscWykonan)
            {
                wynik = wynik/iloscWykonan;
                System.out.println("Średni czas wykonania: " + (wynik)/1000000 + " ms");
            }

        }
        System.out.print("\n");
        System.out.println("Knuth-Morris-Pratt");
        KnuthMorrisPrattFunkcja.KMP(P,T, true);
        wynik = 0.0;
        for (int i = 1; i <= iloscWykonan; i++) {

            time1 = System.nanoTime();
            KnuthMorrisPrattFunkcja.KMP(P,T, false);
            time2 = System.nanoTime();

            wynik+= (time2-time1);

            if(i==iloscWykonan)
            {
                wynik = wynik/iloscWykonan;
                System.out.println("Średni czas wykonania: " + (wynik)/1000000 + " ms");
            }

        }

    }
}
