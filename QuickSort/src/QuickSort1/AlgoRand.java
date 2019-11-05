package QuickSort1;

import java.util.Random;

public class AlgoRand {
        private void Swap(int A[],int i, int j)
        {
            int memo;
            memo = A[i];
            A[i] = A[j];
            A[j] = memo;
        }
        public int[] RandomizedQuicksort(int A[],int p, int r){
            if(p<r)
            {
                int q = RandomizedPartition(A,p,r);
                RandomizedQuicksort(A,p,q);
                RandomizedQuicksort(A,q+1,r);
            }
            return A;
        }
        public int RandomizedPartition(int A[],int p, int r) {
            AlgNorm partition = new AlgNorm();
            Random random = new Random();
            Swap(A,random.ints(p,(r+1)).findFirst().getAsInt(),r);
            return partition.Partition(A,p,r);
        }
}
