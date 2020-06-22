package LCS;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LCS {

    public static void startLCS(String xString, String yString){
        int xStringLength = xString.length()+1;
        int yStringLength = yString.length()+1;

        char[] x = new char[xStringLength];
        char[] y = new char[yStringLength];

        int[][] c = new int[xStringLength][yStringLength];
        char[][] b = new char[xStringLength][yStringLength];

        for(int i = 1; i < xStringLength; i++){
            x[i] = xString.charAt(i-1);
        }

        for(int i = 1; i < yStringLength; i++){
            y[i] = yString.charAt(i-1);
        }

        Length(x,y,b,c);
    }


    private static void Length(char[] x, char[] y, char[][] b, int[][] c){
        int m = x.length;
        int n = y.length;
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            c[i][0] = 0;
        }

        for(int j = 0; j < n; j++){
            c[0][j] = 0;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(x[i]==y[j]){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = '\\';
                }
                else if(c[i-1][j] > c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = '|';
                }
                else if(c[i-1][j] == c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = '*';
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = '-';
                }
                PrintLCS(x,b,m-1,n-1,"",list);
            }
        }
        int val = list.size();
        int val2 = list.get(val-1).length();
        list.removeIf(s -> s.length() < val2);
        LinkedHashSet<String> lhs = new LinkedHashSet<>(list);

        for(String s: lhs){
            System.out.println(s);
        }
    }

    private static void PrintLCS(char[] x,char[][] b,int i,int j, String str, ArrayList<String> list) {
        if(i==0 || j ==0){
            return;
        }
        if(b[i][j] == '\\'){
            str = x[i] + str;
            list.add(str);
            PrintLCS(x,b,i-1,j-1, str, list);
        }
        else if (b[i][j] == '|'){
            PrintLCS(x,b,i-1,j, str, list);
        }
        else if(b[i][j] == '*'){
            PrintLCS(x,b,i,j-1, str, list);
            PrintLCS(x,b,i-1,j, str, list);
        }
        else{
            PrintLCS(x,b,i,j-1, str, list);
        }
    }
}
