import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class start {
    public static void main(String[] args) throws IOException {
        int wiersz = 0;
        int N = 0;
        int x = 0;
        int index = 0;
        HashMap<Integer, ArrayList<Integer>> v = new HashMap<>();
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("graf.txt"));  //wczytywanie pliku do mapy czyli ktora sklada sie z par (wierzcholek, lista tablicowa przedstawiajaca liste sasiedztw)
        String line = reader.readLine();                                    //lista sasiedztw nie ma w sobie bezposrednio pierwszego elementu ktorym jest wierzcholek
        while (line != null)                                                //mozemy uznac ze cala lista jest klucz + lista mu przypisana
        {
            if(wiersz==0)
            {
                N = Integer.parseInt(line);
                    wiersz++;
            }
            else
            {
                ArrayList<Integer> lista = new ArrayList<>();
                String[] tab = line.split(" ");
                for (String s: tab) {
                    if(s.equals("1")){
                        lista.add(index);
                    }
                    index++;
                }
                index = 0;
                v.put(x,lista);
                x++;
            }
            line = reader.readLine();
        }
        int wierzcholek = 2;
        System.out.println("LISTA SASIEDZTW");  //lista sasiedztw bezposrednio po wczytaniu z pliku
        for (Integer w: v.keySet()) {
            System.out.print(w);
            for (Integer z: v.get(w)) {
                System.out.print(" -> " + z);
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("Przeszukiwanie dfs: ");
        String wynikDFS = dfs.dfs_function(v,wierzcholek);
        System.out.println(wynikDFS);
        System.out.println("KRAWEDZIE OTRZYMANEGO LASU SPINAJACEGO");
        for (int i = 1; i < wynikDFS.length(); i++)
        {
            System.out.println(wynikDFS.charAt(i-1) + " - " + wynikDFS.charAt(i));
        }
        System.out.println();
        System.out.print("Przeszukiwanie bfs: ");
        String wynikBFS = bfs.bfs_function(v,wierzcholek);
        System.out.println(wynikBFS);
        System.out.println("KRAWEDZIE OTRZYMANEGO LASU SPINAJACEGO");
        for (int i = 1; i < wynikBFS.length(); i++)
        {
            System.out.println(wynikBFS.charAt(i-1) + " - " + wynikBFS.charAt(i));
        }

    }
}
