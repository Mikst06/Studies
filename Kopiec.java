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
        for(int i = ((y-x+1)/2)+x-1; i>=x ;i--) // (y-x+1) to inaczej ilosc elementow kopca,
        {
            Heapify(A,i);
        }
        return A;
    }
    public int[] HeapSort(int[] A){
        BuildHeap(A);
        for(int i = y; i>x ;i--) //x odpowiada za korzeń, y za podmienianego z korzeniem syna ( y to granica gorna wiec tez ostatni element ciagu )
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
        ///////////////////////////////OBLICZENIE WIELKOSCI TABLICY///////////////////////////////
        int size = 0;
        File file = new File("liczby.txt");//plik wejsciowy
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            size++;
        }
        //////////////////////////////WCZYTYWANIE LICZB DO TABLICY/////////////////////////////////
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
        if( (x+1 >= 1) && ( y+1 >= x+1 ) ){  //sprawdzenie czy x i y spełniają warunki zadania
            indeks = 0;
            int[] A = new int[size - 2];// inicjalizacja tablicy
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) { //petla wczytujaca liczby do tablicy
                if (indeks < 2) {
                    indeks++;
                } else {
                    A[indeks - 2] = Integer.parseInt(st);
                    indeks++;
                }
            }
            kopiec.newSize(y - x + 1); //przekazanie wielkosci tablicy do klasy Sortowanie
            kopiec.wczytajXY(x, y); // przekazanie wartosci x oraz y do klasy Sortowanie
            //////////////////////////////SORTOWANIE PRZEZ KOPCOWANIE//////////////////////////////////
            A = kopiec.HeapSort(A);
            //////////////////////////////WPISYWANIE WYNIKU DO PLIKU WYJŚCIOWEGO///////////////////////
            PrintStream ps = new PrintStream("wynik.txt"); //nazwa pliku wyjsciowego
            for (int i = 0; i < A.length; i++) {
                ps.println(A[i]);
            }
        }
        else // jeżeli x lub y nie spełnia warunków zadania do użytkownika wysłany jest komunikat
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
