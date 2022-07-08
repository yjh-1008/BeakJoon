import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(int[] arr, int n, int m){
        int answer=0;

        for(int lt=0;lt<arr.length;lt++){
            int sum=arr[lt];
            for(int rt=lt+1;rt<arr.length;rt++){
                sum+=arr[rt];
                if(sum==m){
                    answer++;
                    break;
                }else if(sum>m){
                    break;
                }
            }
        }
       System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] =  new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        solution(arr, N,M);


    }
}