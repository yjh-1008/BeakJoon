import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean chk[];
    static ArrayList<Integer>[] arr;
    static int sol[];
    static void dfs(int i){
        if(chk[i]){
            return;
        }
        chk[i]=true;
        for(int v:arr[i]){
            if( !chk[v]){
                sol[v]= i;
                dfs(v);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new ArrayList[n+1];
        chk = new boolean[n+1];
        sol = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=1;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i=1;i<n;i++){
            if(!chk[i]){
                dfs(i);
            }
        }
        for (int i = 2; i <=n ; i++) {
            System.out.println(sol[i]);
        }
        sc.close();
    }
}
