package DAY10.B11062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11062 {
    static int t;
    static int n;
    static int[][] dp;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for(int k=0;k<t;k++){
            n= Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            dp = new int[n][n];
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solution(0,n-1,true);
            System.out.println(dp[0][n-1]);
        }
    }

    public static int solution(int left, int right,boolean turn){
        //left와 right가 교차되면
        if(left> right){return 0 ;}

        if(dp[left][right]!=0){ return dp[left][right];}

        if(turn){ //근우의 차례
            //dp에는 이전의 결과값 + 내가 이번에 뽑을 점수
            return dp[left][right] = Math.max(arr[left]+solution(left+1,right,false),arr[right]+solution(left,right-1,false));
        }else{//명우의 차례
            return dp[left][right] = Math.min(solution(left+1,right,true),solution(left,right-1,true));
        }

    }
}
