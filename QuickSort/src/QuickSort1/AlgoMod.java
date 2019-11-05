package QuickSort1;

public class AlgoMod {
    private void Swap(int A[], int i, int j) {
        int memo;
        memo = A[i];
        A[i] = A[j];
        A[j] = memo;
    }

    public int[] Quicksort(int A[], int p, int r, int c) {
        if (p < r) {
            if ((r - p + 1) > c) {
                int q = Partition(A, p, r);
                Quicksort(A, p, q, c);
                Quicksort(A, q + 1, r, c);
            }
            else
            {
                BubbleSort(A,p,r);
            }
        }

        return A;
    }

    public int Partition(int A[], int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r; j++) {
            if (A[j] <= x) {
                i++;
                Swap(A, i, j);
            }
        }
        if (i < r) {
            return i;
        } else {
            return (i - 1);
        }
    }

    public int[] BubbleSort(int A[], int p, int r) {
       for (int i = 0; i < (r - p); i++) {
            for (int j = 0; j < (r - p - i); j++) {
                if (A[j + p] > A[j + 1 + p]) {
                    Swap(A, j + p, (j + 1 + p));
                }
            }
        }
        return A;
    }

}