import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int answer=0;
    public static void solution(int[] arr, int n,int x){
        int start=0;
        int end = n-1;
        int sum;
        while(start<end){
            sum = arr[start]+arr[end];
            if(sum==x) answer++;

            if(sum<x) start++;
            else end--;
        }
        System.out.print(answer);
    }
    //1 2 3 5 7 9 10 11 12
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int x = sc.nextInt();
        solution(arr, N, x);
        //System.out.println(answer);
    }
}