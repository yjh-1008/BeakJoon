package DAY03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042 {
    static int N;
    static int M;
    static int K;
    static int S;
    static long leafArr[];
    static long tree[];
    public static void initBU(){
        // Leaf에 값 반영
        for(int i=0;i<N;i++){
            tree[S+i] = leafArr[i];
        }

        // 내부노드 채움
        for(int i=S-1;i>0;i--){
            tree[i]= tree[i*2]+tree[i*2+1];
        }
    }

    public static void updateTD(int left, int right, int node, int target, long diff){
        //연관없음
        if(target<left || target>right){
            return;
        }
        //연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff전달
        else{
            tree[node] +=diff;
            int mid = (left+right)/2;
            if (left != right) {
                updateTD(left,mid,node*2,target,diff);
                updateTD(mid+1,right,node*2+1,target,diff);
            }

        }
    }
    public static long query(int left, int right, int node, int queryLeft, long queryRight){
        // 연관이 없음 -> 결과에 영향이 없는 값 return
        if (queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값 return
        else if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 판단불가, 자식에게 위임, 자식에서 올라온 합을 return
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            long resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        leafArr = new long[N];
        for(int i=0;i<N;i++){
            leafArr[i]= Long.parseLong(br.readLine());
        }
        //S의 개수 구하기
        S=1;
        while(S<N){
            S*=2;
        }
        tree = new long[2*S];
        //리프노드 값 넣기
        initBU();
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1){//b번째 수를 c로 바꿈
                long diff = c-tree[S+b-1];
                updateTD(1,S,1,b,diff);

            }else if(a==2){//b부터 c까지의 합을 출력
                System.out.println(query(1,S,1,b,c));
            }
        }
    }
}
//       15(1~8)
//   10     5
// 3   7(3~4)   5   0
//1 2 3 4 5 0 0 0