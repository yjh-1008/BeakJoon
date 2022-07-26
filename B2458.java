package DAY07;

import java.util.ArrayList;
import java.util.Scanner;

public class B2458 {
    static int N;
    static int M;
    static boolean visited[];
    static int inOrder=-1;
    static int outOrder=0;
    static int[] count;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        count = new int[N+1];
        list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
        }
        for(int i=1;i<=N;i++) {
            visited = new boolean[N+1];
            dfs(i);
        }dfs(1);
        for(int a :count){
            System.out.println(a);
        }
    }

    static void dfs(int idx){
        //체크인
        visited[idx]=true;
        inOrder++;
        //목적지 => inorder와 outorder가 전체 인원수 -1만큼 되어야 나의 순서를 알 수 있다.
        //연결된 곳을 간다.
        for(int i : list.get(idx)){
            //갈수있는가?
            if(!visited[i]){
                //간다
                //System.out.println(i);

                dfs(i);
                //
            }
        }
    }
}
