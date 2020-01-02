package Haszowanie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Zadanie_6_2 {
    public static long Convert(String slowo,long stala, int m){
        long wartoscPoConvert = stala * (long) slowo.charAt(0) + slowo.charAt(1);
        for(int i = 2; i<slowo.length(); i++){
            wartoscPoConvert=wartoscPoConvert*stala+ (long) slowo.charAt(i);
            if(i%3==0){wartoscPoConvert=wartoscPoConvert%m;}
        }
        return wartoscPoConvert;
    }

    private static int[] Zerowanie(int T[]){
        for(int i = 0; i<T.length; i++){
            T[i] = 0;
        }
        return T;
    }

    public static void LiczenieKolizji(long stala, int m) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("slowa.txt"));
        String slowo;
        int T[] = new int[m];
        Zerowanie(T);
        for(int i = 0; ((slowo = read.readLine())!=null) && (i<2*m); i++){
            T[(int) Convert(slowo,stala,m)%m] += 1;
        }
        int max = 0;
        int miejscaZerowe = 0;
        int srednia = 0;
        for(int i = 0; i<T.length; i++){
            if(T[i]==0){miejscaZerowe++;}
            else if(T[i]>max){max=T[i];}
            srednia+= T[i];
        }
        double srednia2=((srednia*1.0)/(T.length-miejscaZerowe*1.0));
//        for(int i = 0; i<T.length; i++){System.out.println("T["+i+"]"+T[i] + " ");}
        System.out.format("  %d  |  %d  |          %d         |          %d          |      %.2f\n",m,stala,max,miejscaZerowe,srednia2);
    }
}