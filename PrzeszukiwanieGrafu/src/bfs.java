import java.util.*;

public class bfs {
    static String wynik = "";
    static List<Integer> visited = new ArrayList<>();
    static List<Integer> q = new LinkedList<>();  //zamiast kolejki uzylem listy, jako ze dodawanie elementow do listy dziala tak samo jak do kolejki to uznalem ze bedzie to lepszy zamiennik
    public static String bfs_function(HashMap<Integer, ArrayList<Integer>> v, int s)
    {
        visited.add(s);
        q.add(s);
        while(!q.isEmpty())
        {
            int u = q.get(0);  //tak jak w pseudokodzie, tutaj przypisujemy wartosc, a linijke nizej 'sciagamy' ja z kolejki (listy)
            q.remove(0);
            wynik+=u;
            for (Integer w: v.get(u)) {
                if(!visited.contains(w))
                {
                    visited.add(w);
                    q.add(w);
                }
            }
        }
        return wynik;
    }
}
