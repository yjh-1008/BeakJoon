package DAY03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2243 {
    static int N;
    static int S;
    static int[] tree;
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S=1;
        while(S<MAX){
            S *= 2;
        }
        tree = new int[S*2];
        StringTokenizer st;
        //사탕의 최대 종류를 가져와야함
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 1){ //사탕을 꺼내는 경우
                System.out.println(query(1,S,1, b));
            }else if(a == 2){//사탕을 넣는 경우
                long c = Long.parseLong(st.nextToken());//사탕의 개수
                update(1,S,1,b,c);
            }
        }

    }

    public static int query(int left, int right, int node, int target){
        if(left>= right){
            update(1,S,1, left,-1);
            return left;
        }else{
            int mid = (left+right)/2;
            if(target <= tree[node*2]){
                return query(left, mid, node*2, target);
            }else{
                return query(mid+1, right, node*2+1, target-tree[node*2]);
            }
        }
    }

    public static void update(int left, int right, int node, int target, long diff){
        if(target<left || target> right){
            return;
        }else{
            tree[node]+=diff;
            int mid = (left+right)/2;
            //재귀
            if(left!=right) {
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}



//2 0 0 3
