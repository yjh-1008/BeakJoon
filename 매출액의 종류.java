import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(int[] arr, int n, int k){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hash= new HashMap<>();
        for(int i=0;i<k;i++){
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        answer.add(hash.size());
        int lt=0;
        for(int rt=k;rt<n;rt++){
            hash.put(arr[rt],hash.getOrDefault(arr[rt],0)+1);
            if(hash.get(arr[lt])-1 == 0){
                hash.remove(arr[lt]);
            }else{
                hash.put(arr[lt],hash.get(arr[lt])-1);
            }
            lt++;
            answer.add(hash.size());
        }
        for(int a: answer){
            System.out.print(a+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        solution(arr, N, K);
    }
}