package wzorce;

import java.util.List;

public class KnuthMorrisPrattFunkcja {
    public static void KMP(List<Character> P, List<Triple> T, boolean war)
    {
        int n = T.size();
        int m = P.size();
        int[] pi = new int[P.size()];
        Prefix_Function(P, pi);
        int q = 0;
        for (int i = 0 ;i < n; i++) {
            while( (q > 0) && P.get(q) != T.get(i).getL())
            {
                q=pi[q-1];
            }
            if(P.get(q) == T.get(i).getL())
            {
                q++;
            }
            if(q==m)
            {
                if(war){
                System.out.println("Wiersz: " + T.get(i-m+1).getS() + "   Pozycja: " + T.get(i-m+1).getR());}
                q=pi[q-1];
            }
        }
        
    }

    private static void Prefix_Function(List<Character> P, int[] pi)
    {
        int m = P.size();
        pi[0] = 0;
        int k = 0;
        for (int q = 1; q < m; q++) {
            while(k>0 && P.get(k) != P.get(q))
            {
                k = pi[k];
            }
            if(P.get(k) == P.get(q))
            {
                k++;
            }
            pi[q] = k;
        }
    }

}
