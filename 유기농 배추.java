import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
class LinkedList{
    static int[] toX={0,0,-1,1};
    static int[] toY={1,-1,0,0};
    static void dfs(int[][] arr, boolean[][] chk, int x, int y){
        chk[x][y]=true;
        for(int i=0;i<toX.length;i++){
            if((x+toX[i]>=0 &&y+toY[i]>=0) &&(x+toX[i]<arr.length &&y+toY[i]<arr[0].length) &&(arr[x+toX[i]][y+toY[i]]==1 && !chk[x+toX[i]][y+toY[i]]) ){
                dfs(arr,chk,x+toX[i],y+toY[i]);
            }
        }
    }
    public static void put(int[][] arr, int x, int y){
        arr[x][y]=1;
    }
    static public void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int n= sc.nextInt();
        for(int k=0;k<n;k++) {
            int col = sc.nextInt();//가로
            int row = sc.nextInt();//새로
            int nC = sc.nextInt(); //배추의 개수
            int[][] arr = new int[row][col];
            int answer=0;
            boolean[][] chk = new boolean[row][col];
            for (int i = 0; i < nC; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                put(arr, v2, v1);//단방향으로 연결
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 1 && !chk[i][j]) {
                        dfs(arr, chk, i, j);
                        answer++;
                    }
                }
            }
           sb.append(answer+"\n");
        }
        System.out.print(sb.toString());
    }
}
