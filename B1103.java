package DAY11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1103 {
    static int N;
    static int M;
    static String[][] arr;
    static int [][] dp;
    static boolean[][] visited;
    static int toX[] = {0,0,-1,1};
    static int toY[] = {1,-1,0,0};
    static boolean chk=false;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<M;j++){
                arr[i][j]=str[j];
            }
        }
        visited[0][0]=true;
        dfs(0,0,0);
        if(chk){
            System.out.print(-1);
        }else{
            System.out.print(answer);
        }

    }

    static public void dfs(int s, int e,int count){
            //체크인
            visited[s][e]=true;
            count++;
            if(answer<count){
                answer=count;
            }
            dp[s][e] = count;
            //연결된 곳을 순회
            int move = Integer.parseInt(arr[s][e]);
            //갈수 있눈가?
            for(int i=0;i<4;i++){
                int moveX = s+(toX[i]*move);
                int moveY = e+(toY[i]*move);
                if( moveX<0 || moveY <0 || moveX>=N || moveY>=M || arr[moveX][moveY].equals("H") ){
                    continue;
                }else{
                    if(visited[moveX][moveY]){
                        chk = true;
                        return;
                    }
                    if(dp[moveX][moveY]<count){
                        dfs(moveX,moveY,count);
                    }

                }

            }
            visited[s][e]=false;
            count--;
        }

    }
