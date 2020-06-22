package wzorce;

import java.util.List;

public class RabinKarpFunkcja {
    public static void RabinKarp(List<Character> P, List<Triple> T, int d, int q, boolean war)
    {
        int n = T.size();
        int m = P.size();
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        int p = 0;
        int t = 0;

        for (int i = 0; i < m; i++) {
            p = (d*p + (int) P.get(i)) % q;
            t = (d*t + Character.codePointAt(new char[] {(char) T.get(i).getL()},0)) % q;
        }

        for (int s = 0; s <= ( n - m ) ; s++) {
            if( p == t)
            {
                if(funkcjePomocnicze.porownaj(P, T, m, s))
                {
                    if(war){
                    System.out.println("Wiersz: " + T.get(s).getS() + "   Pozycja: " + T.get(s).getR());}
                }
            }

            if(s < n-m)
            {
                int t1 = (Character.codePointAt(new char[] {(char) T.get(s).getL()},0) * h) % q;

                if (t<t1) t=t+q;

                t = (d*(t-t1)+ Character.codePointAt(new char[] {(char) T.get(s+m).getL()},0)) % q;
            }
        }
    }

}
