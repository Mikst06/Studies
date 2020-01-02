package Radix;

import java.io.IOException;
import java.util.Arrays;

public class RadixSort {
    private void countingSort(String[] A, int index, int[] dlugoscNapisow, String[] wynik) throws IOException
    {
//        System.out.print("\nINDEX: " + index + "\n");

        int n = A.length;

        int[] dlugoscNapisow2 = new int[n];

        int k = 256;

        String B[] = new String[n];

        int C[] = new int[k];

        for(int i = 0; i < k; i++)
        {
            C[i] = 0;
        }

        for(int j = 0; j < n; j++)
        {
            if(dlugoscNapisow[j] >= (index+1)){
            C[(int) A[j].charAt(index)] = C[(int) A[j].charAt(index)] + 1;}
            else{
                C[0]+=1;
            }
        }

        for(int i = 1; i < k; i++)
        {
            C[i] += C[i-1];
        }

        for(int j = (n-1); j >= 0; j--)
        {
            if(dlugoscNapisow[j] >= (index+1)) {
//                System.out.println("C[] = " + (C[(int) A[j].charAt(index)] - 1) + " dla " + A[j].charAt(index) + " słowo " + A[j]);
                B[C[(int) A[j].charAt(index)] - 1] = A[j];
                C[(int) A[j].charAt(index)] = C[(int) A[j].charAt(index)] - 1;
               dlugoscNapisow2[C[(int) A[j].charAt(index)]] = dlugoscNapisow[j];
            }
            else{
//                System.out.println("C[] = " + (C[0] - 1) + " dla " + "POZA INDEKSEM" + " słowo " + A[j]);
                B[C[0] - 1] = A[j];
                C[0] = C[0] - 1;
                dlugoscNapisow2[C[0]] = dlugoscNapisow[j];
            }
        }

//        System.out.print("\n");
//        for(int i = 0; i<n; i++){
//            if(dlugoscNapisow2[i] >= (index+1)) {
//                System.out.print(B[i].charAt(index) + "  " + B[i]+"\n");
//            }
//            else {
//                System.out.print("POZA INDEKSEM" + "  " + B[i]+"\n");
//            }
//        }
//        System.out.print("\n");

        if(index>0)
        {
            A = B;
            countingSort(A,index-1, dlugoscNapisow2, wynik);

        }
        else {
            for(int i = 0; i < n ; i++)
            {
                wynik[i] = B[i];
            }
        }
    }

    public void radixMain(String[] A, String[] wynik) throws IOException {
        int[] dlugoscNapisow = new int[A.length];
        ustawDlugoscNapisow(A,dlugoscNapisow);
        countingSort(A, Arrays.stream(dlugoscNapisow).max().getAsInt() - 1,dlugoscNapisow, wynik);

    }

    private void ustawDlugoscNapisow(String[] A,int[] dlugoscNapisow){
        for(int i = 0; i<A.length; i++){
            dlugoscNapisow[i] = A[i].length();
        }
    }

}
