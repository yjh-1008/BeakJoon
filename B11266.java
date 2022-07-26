package DAY07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11266 {
    static int V;
    static int E;
    static int visitOrder[];
    static ArrayList<Integer>[] list;
    static boolean chk[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E =  Integer.parseInt(st.nextToken());
        list = new ArrayList[V+1];
        chk = new boolean[V+1];
        visitOrder = new int[V+1];
        for(int i=0;i<=V;i++){
            list[i]= new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for(int i=1;i<=V;i++){
            if(visitOrder[i]==0){
                dfs(0,i,true);
            }
        }

    }

    public static int dfs(int parent, int cur, boolean isRoot){
        if(visitOrder[cur]!=0) return 0;
        int min_visit_order = 10010;
        int chlCnt = 0;
        return 0;

    }
}
