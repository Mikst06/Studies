package QuickSort1;

public class BombelSort {
    private void Swap(int A[], int i, int j) {
        int memo;
        memo = A[i];
        A[i] = A[j];
        A[j] = memo;
    }

    public int[] BubbleSort(int A[], int p, int r) {
        for (int i = 0; i < (r - p); i++) {
            for (int j = 0; j < (r - p - i); j++) {
                if (A[j + p] > A[j + 1 + p]) {
                    Swap(A, j + p, (j + 1 + p));
                }
            }
        }
/*        for(int i=0;i<r;i++)
        {
            for(int j=p;j<r-i;j++){
                if(A[j]>A[j+1]){
                    Swap(A,j,j+1);
                }
            }
        }*/
        return A;
    }

}
