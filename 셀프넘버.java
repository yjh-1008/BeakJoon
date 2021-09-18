import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    /*static class dfs{
        private int nV;
        private int [][] arr;
        private boolean chk[];
        dfs(int nV){
            this.nV=nV;
            this.arr =new int[this.nV+1][this.nV+1];
            this.chk = new boolean[nV+1];
        }
        public void put(int v1, int v2){
            arr[v1][v2]=arr[v2][v1]=1;
        }

        public void start(int st){
            chk[st]=true;
            System.out.print(st+"  ");
            for(int i=1;i<arr.length;i++){
                if(arr[st][i]==1 && !chk[i] ){
                    start(i);
                }
            }
        }
    }
    static class bfs{
        private int nV;
        private Queue<Integer> q;
        private int arr[][];
        private boolean chk[];
        bfs(int nV){
            this.nV=nV;
            q=new LinkedList<>();
            this. arr=new int[nV+1][nV+1];
            this.chk=new boolean[this.nV+1];
        }
        public void put(int v1,int v2){
            arr[v1][v2]=arr[v2][v1]=1;
        }
        public void start(int st){
            chk[st]=true;
            q.add(st);
            while(!q.isEmpty()){
                int temp=q.poll();
                System.out.print(temp+" ");
                for(int i=1;i<=nV;i++){
                    if(!chk[i] && arr[temp][i]==1){
                        q.add(i);
                        chk[i]=true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int nV=sc.nextInt();//정점의 개수
        int nE=sc.nextInt();// 간선의 개수\
        dfs dfs_array=new dfs(nV);
        bfs bfs_array=new bfs(nV);
        for(int i=0;i<nE;i++){
            int v1=sc.nextInt();
            int v2= sc.nextInt();
            dfs_array.put(v1,v2);
            bfs_array.put(v1,v2);
        }
        for(int i=1;i<dfs_array.arr.length;i++){
            for(int j=1;j<dfs_array.arr.length;j++){
                System.out.print(dfs_array.arr[i][j]);
            }
            System.out.println();
        }
        //dfs_array.start(1);
        bfs_array.start(3);
    }*/
    /*static int count=0;
    static int minus_stone(int N){
        if(N<3){
            return N;
        }
        while(N>=3){
            N-=3;
            count++;
        }
        return N;
    }*/
    static boolean chk[];
    static void isSelfNumber(int i){
        int sum=0;
        int temp=i;
        int div=10;
        while(temp>0){
            sum+=temp%div;
            temp=temp/div;
        }
        sum+=i;
        if(sum<10000) {
            //System.out.println(sum);
            chk[sum] = true;
        }
    }
    static public void main(String[] args) throws IOException {
        chk=new boolean[10000];
        for(int i=0;i<chk.length;i++){
            isSelfNumber(i);
        }
        for(int i=0;i<chk.length;i++){
            if(!chk[i]){
                System.out.println(i);
            }
        }
    }
}