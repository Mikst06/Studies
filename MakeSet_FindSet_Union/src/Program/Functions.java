package Program;

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

    public static void PrintSciezka(Node x)
    {
        if(x!=x.getParent())
        {
            System.out.print(x.getKey() + "---");
            PrintSciezka(x.getParent());
        }
        else
        {
            System.out.print(x.getKey() + " (ROOT)" + "------> ranga drzewa: " + x.getRank() + "\n");
        }
    }

}
