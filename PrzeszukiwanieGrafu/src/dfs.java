import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dfs {
    static String wynik = "";
    static List<Integer> visited = new ArrayList<>();
    public static String dfs_function(HashMap<Integer, ArrayList<Integer>> v, int u)
    {
        wynik+=u;
        visited.add(u);
        for (Integer w: v.get(u)) {
            if(!visited.contains(w))
            {
                dfs_function(v,w);
            }
        }
        return wynik;
    }
}
