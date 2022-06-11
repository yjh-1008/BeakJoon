import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int answer;
    static int[] toX = {0,0,-1,1};
    static boolean[][] chk;
    static int [] toY = {1,-1,0,0};
    static void dfs(int r,int c){
        chk[r][c]=true;
        for(int i=0;i<4;i++){
            int moveX = r+toX[i];
            int moveY = c+toY[i];
            if(moveX>=0 && moveY>=0 && moveX<arr.length &&  moveY<arr[0].length && arr[moveX][moveY]==1 && !chk[moveX][moveY]){
                dfs(moveX,moveY);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            answer=0;
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            arr = new int[M][N];
            chk = new boolean[M][N];
            for(int j=0;j<K;j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a][b] = 1;
            }

            for(int j=0;j<M;j++){
                for(int q=0;q<N;q++){
                    if(arr[j][q]==1 && !chk[j][q]){
                        dfs(j,q);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
