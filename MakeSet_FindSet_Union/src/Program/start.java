package Program;

public class start {
    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        Node[] Z = new Node[arr.length];

        for (int i = 0; i < Z.length; i++) {
            Z[i] = Functions.MakeSet(arr[i]);
        }
        Functions.Union(Functions.FindSet(Z[0]),Functions.FindSet(Z[1]));
        Functions.Union(Functions.FindSet(Z[2]),Functions.FindSet(Z[3]));
        Functions.Union(Functions.FindSet(Z[1]),Functions.FindSet(Z[2]));
        Functions.Union(Functions.FindSet(Z[5]),Functions.FindSet(Z[6]));
        Functions.Union(Functions.FindSet(Z[7]),Functions.FindSet(Z[8]));
        Functions.Union(Functions.FindSet(Z[3]),Functions.FindSet(Z[5]));
        Functions.Union(Functions.FindSet(Z[0]),Functions.FindSet(Z[7]));

        for (int i = 0; i < Z.length; i++) {
            Functions.PrintSciezka(Z[i]); //funkcja printujaca sciezke wezla do korzenia oraz range drzewa w ktorym znajduje sie dany wezel
        }

        /*
                    Końcowy obraz drzewa (drzewo z AL12.1)

                            	 0     (2)
                             / | | | \
                            1  2 3 5  7
                                   |  |
                                   6  8

                                   4 (0)

                                   9 (0)

         */
    }
}
