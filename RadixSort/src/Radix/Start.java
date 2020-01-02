package Radix;

import java.io.*;
import java.util.Arrays;

public class Start {
    public static void main(String[] args) throws IOException {
        File file = new File("nazwiska.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String st;
        String[] w;
        int size = 0;
        while((st = reader.readLine()) != null)
        {
            size++;
        }
        size = size-11500;
        String[] A = new String[size];
        reader = new BufferedReader(new FileReader(file));
        for(int i = 0; i < size; i++) {
            st=reader.readLine();
            w = st.split(" ");
            A[i] = w[1];
        }
        String[] wynik = new String[size];

//        String[] A = {"bbb","bba","abb","aba"};
//        String[] wynik = new String[A.length];

        RadixSort sort = new RadixSort();
        QuickSortWyrazy2 sort2 = new QuickSortWyrazy2();
//        MixedSortWyrazy sort3 = new MixedSortWyrazy();

//        System.out.print("\nTABLICA PRZED SORTEM\n");
//       for(String s: A)
//        {
//            System.out.print(s+"\n");
//        }
//        System.out.print("\n");

        for(int i= 0; i< 100; i++){
            long timeStart1 = System.nanoTime();
            sort.radixMain(A, wynik);
            long timeEnd1 = System.nanoTime();
            long timeStart2 = System.nanoTime();
            sort2.quickMain(A, wynik);
            long timeEnd2 = System.nanoTime();
            System.out.println(i);
        }
        long time1 = 0;
        long time2 = 0;
        for(int i= 0; i< 100; i++){
            long timeStart1 = System.nanoTime();
            sort.radixMain(A, wynik);
            long timeEnd1 = System.nanoTime();
            time1+=(timeEnd1-timeStart1);
            long timeStart2 = System.nanoTime();
            sort2.quickMain(A, wynik);
            long timeEnd2 = System.nanoTime();
            time2+=(timeEnd2-timeStart2);
        }


//        sort3.quickMain(A,wynik,20000);

        String[] wynik2;
        wynik2 = Arrays.copyOf(wynik, A.length);
        PrintStream fileOut1 = new PrintStream("wyjscie.txt");
        System.setOut(fileOut1);
        for (int i = 0; i < wynik2.length; i++) {
                System.out.print(wynik[i] + "\n");
            }

        double timeW1=((double)(time1/100)*0.000001);
        double timeW2=((double)(time2/100)*0.000001);
        System.out.format("COUNTING: %.4f\t\tQUICK: %.4f",timeW1,timeW2);



//        System.out.print("\nTABLICA PO SORCIE\n");
//        for(String s: A)
//        {
//            System.out.print(s+"\n");
//        }
//        System.out.print("\n");
    }
}

