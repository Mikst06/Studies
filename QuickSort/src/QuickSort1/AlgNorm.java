package QuickSort1;

public class AlgNorm {
    public static void Swap(int A[],int i, int j)
    {
        int memo;
        memo = A[i];
        A[i] = A[j];
        A[j] = memo;
    }
    public int[] Quicksort(int A[],int p, int r){
        if(p<r)
        {
            int q = Partition(A,p,r);
            Quicksort(A,p,q);
            Quicksort(A,q+1,r);
        }
        return A;
    }
    public int Partition(int A[],int p, int r)
    {
        int x = A[r];
        int i = p-1;
        for (int j = p;j<=r;j++)
        {
            if(A[j]<=x)
            {
                i++;
                Swap(A,i,j);
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
