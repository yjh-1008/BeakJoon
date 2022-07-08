import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(int[]arr,int n,int m){
        int answer=0;
        for(int i=0;i<n;i++){
            int sum=arr[i];
            if(sum==m){
                answer++;
                continue;
            }
            for(int j=i+1;j<n;j++){
                sum+=arr[j];
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[] arr = new int[N];
        String[] arrData = br.readLine().split(" ");
        br.close();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(arrData[i]);
        }
        solution(arr,N,M);


    }
}