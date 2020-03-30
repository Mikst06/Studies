package huffman;

import java.util.HashMap;

public class funkcje {
    public static void mapaHuffman(Node korzen, String s,HashMap<String,String> mapa)
    {
        if (korzen.lewySyn == null && korzen.prawySyn == null) {

            mapa.put(korzen.znak,s);
            return;
        }
        mapaHuffman(korzen.lewySyn, s + "0",mapa);
        mapaHuffman(korzen.prawySyn, s + "1",mapa);
    }

    public static void printDrzewo(Node korzen, String indent, boolean last) {
        if (korzen != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            System.out.println(korzen.znak);
            printDrzewo(korzen.lewySyn, indent, false);
            printDrzewo(korzen.prawySyn, indent, true);
        }
    }

    public static void printTabela(HashMap<String,Integer> mapInt, HashMap<String,String> mapHuffman)
    {
        System.out.println();
        System.out.print("|\tLICZBA\t|\tILOSC\t|\tHUFFMAN\t|");
        for(String x: mapInt.keySet()){
            System.out.format("\n\t%s\t     \t%d\t    \t%s\t",x,mapInt.get(x),mapHuffman.get(x));
        }

        System.out.println("\n");
    }

    public static void stworzMape(String data, HashMap<String,Integer> mapa, boolean warunek)
    {
        for(int i = 0; i < data.length(); i++){
            String s = "";
            if(warunek)
            {
                if(i==data.length()-1)
                {
                    s = Character.toString(data.charAt(i));
                }
                else
                {
                    s = ""+data.charAt(i)+data.charAt(i+1);
                }

                i++;
            }
            else
            {
                s = Character.toString(data.charAt(i));
            }
            if(!mapa.containsKey(s))
            {
                mapa.put(s,1);
            }
            else
            {
                mapa.compute(s,(k,v) -> v+1);
            }
        }
    }

    public static int zakodowanaDlugosc(HashMap<String,Integer> mapInt,HashMap<String,String> mapHuffman)
    {
        int suma = 0;

        for(String x: mapInt.keySet()){
            suma += mapInt.get(x)*mapHuffman.get(x).length();
        }

        return suma;
    }

}
