package wzorce;

import java.util.List;

public class funkcjePomocnicze {
    public static boolean porownaj(List<Character> P, List<Triple> T, int m, int s)
    {
        boolean wynik = true;
        for (int i = 0; i < m; i++) {
            if(P.get(i) != T.get(i + s).getL())
            {
                wynik = false;
                break;
            }
        }

        return wynik;
    }
}
