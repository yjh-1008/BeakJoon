package DAY07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11404 {
    static final int INF = 9999999;
    static int[][] matrix;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n= Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        matrix = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j && matrix[i][j]==0){
                    matrix[i][j] = INF;
                }
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w =Integer.parseInt(st.nextToken());
            matrix[a][b] = Math.min(matrix[a][b],w);
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==j || j==k) continue;

                    if(matrix[i][j]>matrix[i][k]+matrix[k][j]){
                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
               if(matrix[i][j]==INF){
                   matrix[i][j]=0;
               }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
