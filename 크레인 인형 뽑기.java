import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int answer=0;
    public static void solution(int[][] arr, int n,int[] crain){
        Stack<Integer> stack = new Stack<>();
        int answer=0;
        for(int c: crain){
            for(int i=1;i<=n;i++){
                if(arr[i][c]!=0){
                    if(!stack.isEmpty() && stack.peek()==arr[i][c]){
                        stack.pop();
                        answer+=2;

                    }else{
                        stack.push(arr[i][c]);
                    }
                    arr[i][c]=0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
    //1 2 3 5 7 9 10 11 12
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int m =sc.nextInt();
        int[] crain = new int[m];
        for(int i=0;i<m;i++){
            crain[i] = sc.nextInt();
        }
        solution(arr, N,crain);
    }
}

//4 3 1 1 3 2 4