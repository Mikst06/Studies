//every number in "numbers.txt" must be in other line. First two numbers in file are limits of sequance that you want to sort.
//If you want to sort numbers from third to seventh position first numbers in file shoud be 3 and 7. By position I mean order no index of an array.
//So by 1 I mean first number of an array.
import java.io.*;
class Sorting
{
    private int size;
    private int x,y;
    public void readXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void newSize(int size){
        this.size = size-1;
    }
    public void Heapify(int[] A, int i)
    {
        int largest;
        int l = 2 * i  + 1 - x;
        int r = 2 * i + 2 - x;

        if (( l <= y ) && ( A[l] < A[i] ))
        {
            largest = l;
        }
        else
        {
            largest = i;
        }

        if (( r <= y) && ( A[r] < A[largest] ))
        {
            largest = r;
        }

        if (largest != i)
        {
            int z;
            z = A[i];
            A[i] = A[largest];
            A[largest] = z;
            Heapify(A,largest);
        }
    }
    public int[] BuildHeap(int[] A)
    {
        for(int i = ((y-x+1)/2)+x-1; i>=x ;i--)
        {
            Heapify(A,i);
        }
        return A;
    }
    public int[] HeapSort(int[] A){
        BuildHeap(A);
        for(int i = y; i>x ;i--)
        {
            int z;
            z = A[y];
            A[y] = A[x];
            A[x] = z;
            y = y-1;
            Heapify(A,x);
        }
        return A;
    }

}
public class HeapSortAlgorithm {
    public static void main(String[] args) throws Exception
    {
        Sorting heap = new Sorting();
        int size = 0;
        File file = new File("numbers.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            size++;
        }
        br = new BufferedReader(new FileReader(file));
        int index = 0;
        int x = 0;
        int y = 0;
        while ((st = br.readLine()) != null) {
            if (index == 0) {
                x = Integer.parseInt(st) - 1;
                index++;
            } else if (index == 1) {
                y = Integer.parseInt(st) - 1;
                index++;
            }
        }
        if( (x+1 >= 1) && ( y+1 >= x+1 ) ){
            index = 0;
            int[] A = new int[size - 2];
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null)
                if (index < 2) {
                    index++;
                } else {
                    A[index - 2] = Integer.parseInt(st);
                    index++;
                }
            }
            kopiec.newSize(y - x + 1);
            kopiec.readXY(x, y); 
            A = heap.HeapSort(A);
            PrintStream ps = new PrintStream("result.txt");
            for (int i = 0; i < A.length; i++) {
                ps.println(A[i]);
            }
        }
        else
        {
            System.out.println("The given condition has not been met");
            if(x>y)
                System.out.println((x+1) + " (x) >= (y) " + (y+1));
            if(x+1<1)
            {
                System.out.println((x+1) + " (x) >= 1");
            }
        }
    }
}
