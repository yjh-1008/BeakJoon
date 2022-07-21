package DAY04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14476 {
    static int N;
    static int[] arr;
    static int[] gcd1;
    static int[] gcd2;
    public static int gcd (int a, int b){
        while(b!=0){
            int r = a%b;
            a=b;
            b=r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        gcd1 = new int[N];
        gcd2 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        gcd1[0] = arr[0];

        for(int i=1;i<N;i++){
            gcd1[i] = gcd(gcd1[i-1],arr[i]);

        }
        gcd2[N-1] = arr[N-1];
        for(int i=N-2;i>0;i--){
            gcd2[i] = gcd(gcd2[i+1],arr[i]);
        }
        int max= 0;
        int maxIndex=0;
        for(int k=0;k<N;k++){
            int gcd=0;
            if(k==0){
                gcd = gcd2[1];
            }else if(k==N-1){
                gcd = gcd1[N-2];
            }else{
                gcd= gcd(gcd2[k+1],gcd1[k-1]);
            }

            if(arr[k]% gcd !=0 && gcd>max){
                max= gcd;
                maxIndex=arr[k];
            }
        }
        if(max==0){
            System.out.print(-1);
        }else{
            System.out.print(max+" "+maxIndex);
        }



    }
}
