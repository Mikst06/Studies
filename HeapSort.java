//every number in "numbers.txt" must be in other line. First two numbers in file are limits of sequance that you want to sort.
//If you want to sort numbers from third to seventh position first numbers in file shoud be 3 and 7. By position I mean order no index of an array.
//So by 1 I mean first number of an array.
import java.io.*;
class Sortowanie
{
    private int size;
    private int x,y;
    public void wczytajXY(int x, int y){
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
public class Kopiec {
    public static void main(String[] args) throws Exception
    {
        Sortowanie kopiec = new Sortowanie();
        int size = 0;
        File file = new File("numbers.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            size++;
        }
        br = new BufferedReader(new FileReader(file));
        int indeks = 0;
        int x = 0;
        int y = 0;
        while ((st = br.readLine()) != null) {
            if (indeks == 0) {
                x = Integer.parseInt(st) - 1;
                indeks++;
            } else if (indeks == 1) {
                y = Integer.parseInt(st) - 1;
                indeks++;
            }
        }
        if( (x+1 >= 1) && ( y+1 >= x+1 ) ){
            indeks = 0;
            int[] A = new int[size - 2];
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null)
                if (indeks < 2) {
                    indeks++;
                } else {
                    A[indeks - 2] = Integer.parseInt(st);
                    indeks++;
                }
            }
            kopiec.newSize(y - x + 1);
            kopiec.wczytajXY(x, y); 
            A = kopiec.HeapSort(A);
            PrintStream ps = new PrintStream("result.txt");
            for (int i = 0; i < A.length; i++) {
                ps.println(A[i]);
            }
        }
        else
        {
            System.out.println("Podany warunek nie został spełniony");
            if(x>y)
                System.out.println((x+1) + " (x) >= (y) " + (y+1));
            if(x+1<1)
            {
                System.out.println((x+1) + " (x) >= 1");
            }
        }
    }
}
