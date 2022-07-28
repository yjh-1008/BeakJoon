package DAY09.B14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14002 {
    static int A;
    static int[] arr;
    static int[] D;
    static int[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        A = Integer.parseInt(br.readLine());
        arr = new int[A];
        D =  new int [A];
        chk = new int[A];
        Arrays.fill(chk,-1);
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<A;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx=-1;
        int max=0;
        for(int i=0;i<A;i++){
            D[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    D[i] = Math.max(D[j]+1, D[i]);
                    chk[i] = j;
                }
            }
            if(max<D[i]){
                max = D[i];
            }
        }
        sb.append(max).append("\n");
        for(int a: chk){
            System.out.print(a+" ");
        }
//        while(idx!=-1){
//            sb.append(arr[idx]+" ");
//            idx=chk[idx];
//        }
        System.out.print(sb);
    }
}
