import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        s = br.readLine();
        st = new StringTokenizer(s);
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,Collections.reverseOrder());
        int answer = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k=j+1;k<N;k++){
                    if(arr[i]+arr[j]+arr[k]<=M){
                        answer = Math.max(answer, arr[i]+arr[j]+arr[k]);
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}