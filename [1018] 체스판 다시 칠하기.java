import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static char[][] arr;
    static int answer = Integer.MAX_VALUE;
    static char[][] whiteCheck=
                    {{'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'}};
    static char[][] blackCheck=
                    {{'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                            {'B','W','B','W','B','W','B','W'},
                            {'W','B','W','B','W','B','W','B'}
                    ,{'B','W','B','W','B','W','B','W'},
                            {'W','B','W','B','W','B','W','B'},
                            {'B','W','B','W','B','W','B','W'},
                            {'W','B','W','B','W','B','W','B'}};
    public static void checkBoard(int x, int y){
        int count1=0;
        int count2=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(arr[i+x][j+y] != blackCheck[i][j]){
                    count1++;
                }
                if(arr[i+x][j+y] != whiteCheck[i][j]){
                    count2++;
                }
            }
        }
        answer = Math.min(answer,Math.min(count2,count1));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);
        arr = new char[N][M];
        for(int i=0;i<N;i++){
            str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = str.charAt(j);
            }
        }
        br.close();
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                checkBoard(i,j);
            }
        }
        System.out.println(answer);
    }
}