package QuickSort1;

import java.io.*;
public class AlgoStart {
    public static void main(String[] args) throws IOException {

        final int NUMBER_OF_REPETITIONS = 200;
        final int INCREASING_2000 = 5;
        final int COEFFICIENT_C = 10;
        final double MILLISECONDS = 0.000001;

        int numbers = 2000;
        double allTime1 = 0.0;
        double allTime2 = 0.0;
        double allTime3 = 0.0;
        PrintStream fileOut2 = new PrintStream("output.txt");
        System.setOut(fileOut2);
        System.out.println("RANDOM DATA");
        System.out.println("| \t\tSIZE OF AN ARRAY\t| \tQUICK SORT\t   | \tMIXED QUICKSORT\t | \tBUBBLE SORT\t\t\t |");
        for (int z = 1; z < INCREASING_2000+1; z++,numbers += 2000) {
            for (int q = 1; q < NUMBER_OF_REPETITIONS+1; q++) {
                PrintStream fileOut1 = new PrintStream("input.txt");
                System.setOut(fileOut1);
                for (int i = 0; i < numbers; i++) {
                    System.out.println(RandomNumber.generateRandomIntIntRange(0, 1000));
                }
                File file = new File("input.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                int size = 0;
                while ((st = br.readLine()) != null) {
                    size++;
                }
                int A[] = new int[size];
                int B[] = new int[size];
                int E[] = new int[size];
                br = new BufferedReader(new FileReader(file));
                for (int i = 0; i < size; i++) {
                    st = br.readLine();
                    A[i] = Integer.parseInt(st);
                    B[i] = Integer.parseInt(st);
                    E[i] = Integer.parseInt(st);
                }
                PrintWriter writer = new PrintWriter(file);
                writer.print("");
                AlgNorm sort = new AlgNorm(); //-----------------------------------------------------------------------
                AlgoMod sort2 = new AlgoMod(); //-----------------------------------------------------------------------
                BombelSort bombel = new BombelSort();//-----------------------------------------------------------------------
                long startTime = System.nanoTime();
                sort.Quicksort(A, 0, size - 1);
                long endTime = System.nanoTime();
                long startTime2 = System.nanoTime();
                sort2.Quicksort(B, 0, size - 1, COEFFICIENT_C);
                long endTime2 = System.nanoTime();
                long startTime3 = System.nanoTime();
                bombel.BubbleSort(E, 0, size - 1);
                long endTime3 = System.nanoTime();
                double time = (double) (endTime - startTime);
                double time2 = (double) (endTime2 - startTime2);
                double time3 = (double) (endTime3 - startTime3);
                allTime1 += time;
                allTime2 += time2;
                allTime3 += time3;
                double avgTime1 = (allTime1 / q) * MILLISECONDS;
                double avgTime2 = (allTime2 / q) * MILLISECONDS;
                double avgTime3 = (allTime3 / q) * MILLISECONDS;
                System.setOut(fileOut2);
                if(q==NUMBER_OF_REPETITIONS){
                System.out.format("|\t\t\t%d\t\t\t|\t\t\t%.4f\t\t\t|\t\t\t%.4f\t\t\t|\t\t\t%.4f\t\t\t|\n", numbers, avgTime1, avgTime2, avgTime3);
            }}
            allTime1=0;
            allTime2=0;
            allTime3=0;
        }
        System.out.println("\nAlgortihm repeated " + NUMBER_OF_REPETITIONS + " times.\n");
        System.setOut(fileOut2);

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        numbers = 2000;
        System.out.println("DESCENDING SEQUENCE");
        System.out.println("| \t\tSIZE OF AN ARRAY\t| \tQUICK SORT\t   | \tMIXED QUICKSORT\t | \tBUBBLE SORT\t\t\t |");
        for (int z = 1; z < INCREASING_2000+1; z++, numbers+=2000) {
            for (int q = 1; q < NUMBER_OF_REPETITIONS + 1; q++) {
                String st;
                File file = new File("input.txt");
                PrintStream fileOut1 = new PrintStream("input.txt");
                System.setOut(fileOut1);
                BufferedReader br = new BufferedReader(new FileReader(file));
                for (int i = numbers; i > 0; i--) {
                    System.out.println(i);
                }
                int C[] = new int[numbers];
                int D[] = new int[numbers];
                int E[] = new int[numbers];
                br = new BufferedReader(new FileReader(file));
                for (int i = 0; i < numbers; i++) {
                    st = br.readLine();
                    C[i] = Integer.parseInt(st);
                    D[i] = Integer.parseInt(st);
                    E[i] = Integer.parseInt(st);
                }
                PrintWriter writer = new PrintWriter(file);
                writer.print("");
                AlgNorm sort = new AlgNorm(); //-----------------------------------------------------------------------
                AlgoMod sort2 = new AlgoMod(); //-----------------------------------------------------------------------
                BombelSort bombel = new BombelSort();//-----------------------------------------------------------------------
                long startTime = System.nanoTime();
                sort.Quicksort(C, 0, numbers - 1);
                long endTime = System.nanoTime();
                long startTime2 = System.nanoTime();
                sort2.Quicksort(D, 0, numbers - 1, COEFFICIENT_C);
                long endTime2 = System.nanoTime();
                long startTime3 = System.nanoTime();
                bombel.BubbleSort(E, 0, numbers - 1);
                long endTime3 = System.nanoTime();
                double time = (double) (endTime - startTime);
                double time2 = (double) (endTime2 - startTime2);
                double time3 = (double) (endTime3 - startTime3);
                allTime1 += time;
                allTime2 += time2;
                allTime3 += time3;
                double avgTime1 = (allTime1 / q) * MILLISECONDS;
                double avgTime2 = (allTime2 / q) * MILLISECONDS;
                double avgTime3 = (allTime3 / q) * MILLISECONDS;

                System.setOut(fileOut2);
                if(q==NUMBER_OF_REPETITIONS) {
                    System.out.format("|\t\t\t%d\t\t\t|\t\t\t%.4f\t\t\t|\t\t\t%.4f\t\t\t|\t\t\t%.4f\t\t\t|\n", numbers, avgTime1, avgTime2, avgTime3);
                }
            }
            allTime1=0;
            allTime2=0;
            allTime3=0;
        }
    }
}
