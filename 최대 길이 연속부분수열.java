import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(int[] arr, int n,int k){
        int tmp=k;
        int lt=0,rt=0;
        int answer=0;
        while(rt<n){
            if(lt>=rt){
                rt++;
            }else {
                if (arr[rt] == 0 && tmp > 0) {
                    rt++;
                    tmp--;
                } else if (arr[rt] == 0 && tmp == 0) {
                    if (arr[lt++] == 0) {
                        tmp++;
                    }
                } else if (arr[rt] == 1) {
                    rt++;
                }
            }
            answer = Math.max(answer, rt-lt);

        }
        System.out.print(answer);

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k= sc.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        solution(arr,N,k);


    }
}