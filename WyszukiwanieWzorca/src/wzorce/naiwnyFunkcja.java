package wzorce;

import java.util.List;


public class naiwnyFunkcja {
    public static void naiwny(List<Character> P, List<Triple> T, boolean war)
    {
        int n = T.size();
        int m = P.size();
        for (int s = 0; s <= ( n - m ); s++) {
            if(funkcjePomocnicze.porownaj(P, T, m, s))
            {
                if(war){
                System.out.println("Wiersz: " + T.get(s).getS() + "   Pozycja: " + T.get(s).getR());}
            }
        }
    }
}
