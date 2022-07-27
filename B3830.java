package DAY08.B3830;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B3830 {
    static int n;
    static int m;
    static int[] parent;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        while(true){
            st = new StringTokenizer(br.readLine());
            sb =  new StringBuilder();
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n==0 && m==0){//0이 2개면 리턴
                return;
            }
            parent = new int[n+1];
            dist = new long[n+1];


            for(int i=1;i<=n;i++){
                parent[i]=i;
            }

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                if(cmd.equals("!")){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    union(a,b,c);
                }
                else if(cmd.equals("?")){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if(find(a)!=find(b)){
                        sb.append("UNKNOWN").append("\n");
                        continue;
                    }
                    //두 값을 확인했을 때 부모가 다르면 UNKOWN
                    sb.append(dist[b]-dist[a]).append("\n");

                }
            }
            System.out.print(sb);
        }
    }
    static public void union(int a, int b,long c){
        int x = find(a);
        int y = find(b);
        if(x==y){
            return;
        }

        dist[y] = dist[a]-dist[b]+c;
        parent[y] = x;

    }

    public static int find(int a){
        if(parent[a]==a){
            return a;
        }
        int p = find(parent[a]);
        dist[a] += dist[parent[a]];
        return parent[a] = p;
    }
}
