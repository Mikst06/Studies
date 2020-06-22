package Program;

import java.util.ArrayList;

public class Functions {

    public static Node MakeSet(int k)
    {
        Node x = new Node();

        x.setKey(k);
        x.setParent(x);
        x.setRank(0);

        return x;
    }

    public static Node FindSet(Node x)
    {
        if (x != x.getParent())
        {
            x.setParent(FindSet(x.getParent()));
        }

        return x.getParent();
    }

    public static void Union(Node x, Node y)
    {
        if(x.getRank() < y.getRank())
        {
            x.setParent(y);
        }
        else
        {
            y.setParent(x);
            if(x.getRank()==y.getRank())
            {
                x.setRank(x.getRank() + 1);
            }
        }

    }

    public static void Kruskal(int[] V, ArrayList<Pair<Integer,Integer>> E, int[] w)
    {
        //stworzenie tablicy wezlow
        Node[] Vs = new Node[V.length];
        for (int i = 0; i < Vs.length; i++) {
            Vs[i] = MakeSet(V[i]);
        }

        //sortowanie bombelkowe wag oraz na ich podstawie krawedzi
        for (int i = 0; i < w.length-1; i++) {
            for (int j = 0; j < w.length-i-1; j++) {
                if(w[j] > w[j+1])
                {
                    int temp = w[j];
                    w[j] = w[j+1];
                    w[j+1] = temp;

                    Pair temp2 = E.get(j);
                    E.set(j,E.get(j+1));
                    E.set(j+1,temp2);
                }
            }
        }

        for (int i = 0; i < w.length; i++) {
            Node ru = FindSet(Vs[E.get(i).getL()]);
            Node rv = FindSet(Vs[E.get(i).getR()]);

            if(ru!=rv)
            {
                System.out.format("%d -- %d == %d\n",E.get(i).getL(),E.get(i).getR(),w[i]);
                Union(ru,rv);
            }
        }


    }

}
