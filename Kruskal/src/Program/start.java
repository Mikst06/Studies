package Program;

import java.util.ArrayList;

public class start {
    public static void main(String[] args) {

        //graf dodalem w formacie jpg w folderze 'graf'
        int[] V ={0,1,2,3,4,5};
        //jako ze w javie nie ma odpowiedniej struktury to stworzylem
        //klase Pair dzieki ktorej moge zrobic liste par
        ArrayList<Pair<Integer,Integer>> E = new ArrayList<>();
        E.add(new Pair<>(0,1));
        E.add(new Pair<>(0,2));
        E.add(new Pair<>(0,3));
        E.add(new Pair<>(1,3));
        E.add(new Pair<>(2,3));
        E.add(new Pair<>(0,4));
        E.add(new Pair<>(0,5));
        E.add(new Pair<>(1,4));
        E.add(new Pair<>(3,5));
        int[] w = {7, 2, 5, 10, 1, 8, 4, 16, 3};

        Functions.Kruskal(V,E,w);

    }
}
