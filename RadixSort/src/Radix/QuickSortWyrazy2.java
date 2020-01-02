package Radix;

import java.io.IOException;
import java.util.Arrays;

public class QuickSortWyrazy2 {
    private void quickStart(String[] A, int index, int[] dlugoscNapisow, String[] wynik) throws IOException
    {
//        System.out.print("\nINDEX: " + index + "\n");

        int n = A.length;

        int[] dlugoscNapisow2 = new int[n];

        int[] Ind = new int[n];

        String B[] = new String[n];

        int C[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            if(dlugoscNapisow[i] >= (index+1)) {
                C[i] = (int) A[i].charAt(index);
            }
            else {
                C[i] = 0;
            }
            Ind[i] = i;
        }

        Quicksort(C,0,n-1, Ind);

        for(int i = 0; i < n; i++)
        {
            B[i] = A[Ind[i]];
            dlugoscNapisow2[i] = dlugoscNapisow[Ind[i]];
        }

        if(index>0)
        {
            quickStart(B,index-1, dlugoscNapisow2, wynik);

        }
        else {
            for(int i = 0; i < n ; i++)
            {
                wynik[i] = B[i];
            }
        }
    }

    public void quickMain(String[] A, String[] wynik) throws IOException {
        int[] dlugoscNapisow = new int[A.length];
        ustawDlugoscNapisow(A,dlugoscNapisow);
        quickStart(A, Arrays.stream(dlugoscNapisow).max().getAsInt() - 1,dlugoscNapisow, wynik);

    }

    private void ustawDlugoscNapisow(String[] A,int[] dlugoscNapisow){
        for(int i = 0; i<A.length; i++){
            dlugoscNapisow[i] = A[i].length();
        }
    }

    public static void Swap(int A[],int i, int j)
    {
        int memo;
        memo = A[i];
        A[i] = A[j];
        A[j] = memo;
    }
    public void Quicksort(int A[],int p, int r, int[] Ind){
        if(p<r)
        {
            int q = Partition(A,p,r, Ind);
            Quicksort(A,p,q, Ind);
            Quicksort(A,q+1,r, Ind);
        }
    }
    public int Partition(int A[],int p, int r, int[] Ind)
    {
        int x = A[r];
        int i = p-1;
        for (int j = p;j<=r;j++)
        {
            if(A[j]<=x)
            {
                i++;
                Swap(A,i,j);
                Swap(Ind,i,j);
            }
        }
        if(i<r)
        {
            return i;
        }
        else
        {
            return (i - 1);
        }
    }


}
