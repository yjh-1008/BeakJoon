import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(int[] arr, int n,int k){
        TreeMap<Integer, Integer> answer= new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int t=j+1;t<n;t++){
                    int tmp = arr[i]+arr[j]+arr[t];
                    answer.put(tmp, answer.getOrDefault(tmp,0)+1);
                }
            }
        }
        int tmp=1;
        if(k> answer.size()){
            System.out.println(-1);
        }else{
            for(int a: answer.keySet()){
                if(tmp==k){
                    System.out.print(a);
                    return;
                }else{
                    tmp++;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k =  sc.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        solution(arr,N,k);

    }
}