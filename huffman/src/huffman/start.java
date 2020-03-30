package huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;


class MyComparator implements Comparator<Node> {
    public int compare(Node x, Node y)
    {
        return x.value - y.value;
    }
}

public class start {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("plik.txt"));
        String st;
        StringBuilder sb = new StringBuilder();
        while ((st = br.readLine()) != null)  //by zmienic wartosci uzywane w algorytmie, prosze wejsc do pliku.txt i tam zmienic dane
            sb.append(st);                 //ładowanie pliku do StringBuildera
        HashMap<String,Integer> mapa1 = new HashMap<>();  //stworzenie mapy, w której będzie (liczba, ilość występowań)
        HashMap<String,Integer> mapa2 = new HashMap<>();  //analogiczne co u góry, tylko ta mapa będzie dla podwójnych znaków
        String data = sb.toString(); //przekazanie stringa do Stringa data
        funkcje.stworzMape(data,mapa1,false); //funkcja wpisująca dane do mapy, warunek false oznacza, że będzie dla 1 znaku
        funkcje.stworzMape(data,mapa2,true); // analogiczne jak u góry tylko, że jest warunek true, co sprawia, że będzie dla 2 znaków

        PriorityQueue<Node> q1 = new PriorityQueue<>(mapa1.keySet().size(), new MyComparator()); //używam kolejki, ponieważ kolekcja ta pozwala na szybkie znajdywanie szukanej wartości poprzez stworzenie własnego porównania
        PriorityQueue<Node> q2 = new PriorityQueue<>(mapa2.keySet().size(), new MyComparator());

        //od tego momentu jest tworzenie drzew, wszystko z dopiskiem 1 jest dla 1 znaku, analogicznie dla numeru 2
        Node korzen1 = null;
        Node korzen2 = null;


        for(String x: mapa1.keySet()){
            Node huffman1 = new Node();

            huffman1.znak = x;
            huffman1.value = mapa1.get(x); // przypozadkowanie czestotliwosci wystepowan liczby x

            huffman1.lewySyn = null;
            huffman1.prawySyn = null;

            q1.add(huffman1); //dodanie do kolejki node z wartościami przyznanymi u gory
        }

        while (q1.size() > 1) {

            Node x = q1.peek(); //przypisanie wartosci z kolejki
            q1.poll(); //usuniecie z kolejki liczby

            Node y = q1.peek();
            q1.poll();

            Node z = new Node();

            z.value = x.value + y.value;
            z.znak = "Z";
            z.lewySyn = x;
            z.prawySyn = y;
            korzen1 = z;

            q1.add(z); //dodanie nowego elementu do kolejki, tym razem z nowa wartoscia i powiazany z wartosciami ktore zdjelismy przed chwila
        }

        for(String x: mapa2.keySet()){
            Node huffman2 = new Node();

            huffman2.znak = x;
            huffman2.value = mapa2.get(x);

            huffman2.lewySyn = null;
            huffman2.prawySyn = null;

            q2.add(huffman2);
        }

        while (q2.size() > 1) {

            Node x = q2.peek();
            q2.poll();

            Node y = q2.peek();
            q2.poll();

            Node z = new Node();

            z.value = x.value + y.value;
            z.znak = "Z";
            z.lewySyn = x;
            z.prawySyn = y;
            korzen2 = z;

            q2.add(z);
        }
        HashMap<String,String> mapaHuffman1 = new HashMap<>();//stworzenie mapy, która będzie zwierała (liczbe, jej kod huffmana)
        HashMap<String,String> mapaHuffman2 = new HashMap<>();

        funkcje.mapaHuffman(korzen1, "",mapaHuffman1); //wypełnienie mapy wartościami
        funkcje.printTabela(mapa1,mapaHuffman1); //wyświetlenie wyników dla 1 znaku

        funkcje.mapaHuffman(korzen2, "",mapaHuffman2); //analogicznie jak u gory tylko dla 2 znakow
        funkcje.printTabela(mapa2,mapaHuffman2);

/*        funkcje.printDrzewo(korzen1,"", true);  //funkcje uzyte do sprawdzenia czy drzewo wyglada poprawnie, ta funkcja jest dla jednego znaku
        funkcje.printDrzewo(korzen2,"", true);*/    // ta funkcja dla 2 znakow
        System.out.format("Dlugosc kodowania jednym znakiem = %d\nDlugosc kodowania dwoma znakami = %d",     // wyswietlenie dlugosci zakodowanej i porownanie ich
                funkcje.zakodowanaDlugosc(mapa1,mapaHuffman1),funkcje.zakodowanaDlugosc(mapa2,mapaHuffman2));
    }
}
