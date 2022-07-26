package DAY07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11657 {
    static int N;
    static int M;
    final static int INF = 987654321;
    static ArrayList<Node>[] list;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dist=new long[N+1];
        Arrays.fill(dist, INF);
        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }
        if(bellmanford(1)){
            System.out.println(-1);
        }else{
            for(int i=2;i<=N;i++){
                if(dist[i]==INF){
                    System.out.println(-1);
                }else{
                    System.out.println(dist[i]);
                }
            }
        }

    }

    public static boolean bellmanford(int start){
        boolean chk=false;
        dist[start] = 0;
        for(int i=1;i<N;i++){
            chk = false;
            for(int j=1;j<=N;j++){
                for(Node n: list[j]){
                    if(dist[j]==INF){
                        break;
                    }
                    if(dist[n.e] > dist[j]+n.w){
                        dist[n.e] = dist[j]+n.w;
                        chk = true;
                    }
                }
            }
            if(!chk){
                break;
            }
        }
        if(chk){
            for(int i=1;i<=N;i++){
                for(Node n: list[i]){
                    if(dist[i]==INF){
                        break;
                    }
                    if(dist[n.e] > dist[i]+n.w){
                        System.out.println("Asdas");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Node{
    int e;
    int w;
    Node(int e, int w){
        this.e = e;
        this.w = w;
    }
}
