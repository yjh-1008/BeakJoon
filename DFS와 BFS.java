package sample;


import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

class Main{
    static public StringBuilder sb;
    static class dfsGraph{
        private int nV;
        private int[][] dfsArray;
        private boolean[] visited;
        dfsGraph(int nV){
            this.nV=nV;
            this.dfsArray=new int[nV+1][nV+1];
            this.visited=new boolean[nV+1];
        }

        void put(int x, int y){
            this.dfsArray[x][y]=1;
            this.dfsArray[y][x]=1;
        }
        void dfs(int start){
            visited[start]=true;
            sb=new StringBuilder();
            System.out.print(start+" ");
            for(int i=1;i< dfsArray.length;i++){
                if(!visited[i] && dfsArray[start][i]==1){
                    dfs(i);
                }
            }

        }
    }

    static public class bfsGraph{
        private int nV;
        private boolean visited[];
        private int[][] bfs_array;
        bfsGraph(int nV){
            this.nV=nV;
            this.bfs_array=new int[nV+1][nV+1];
            this.visited= new boolean[nV+1];
        }

        public void put(int x, int y){
            this.bfs_array[x][y]=1;
            this.bfs_array[y][x]=1;
        }

        public void bfs(int start) {
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(start);
            this.visited[start] = true;
            while (!q.isEmpty()) {
                start=q.poll();
                System.out.print(start+" ");
                for(int i=1;i< bfs_array.length;i++){
                    if(!visited[i] && bfs_array[start][i]==1){
                        visited[i]=true;
                        q.add(i);
                    }
                }
            }
        }
    }

    static public void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int nV= sc.nextInt();//정점의 개수
        int nE=sc.nextInt();//간선의 개수
        int start= sc.nextInt();
        dfsGraph dfs = new dfsGraph(nV);
        bfsGraph bfs=new bfsGraph(nV);
        for(int i=0;i<nE;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            bfs.put(v1,v2);
            dfs.put(v1,v2);
        }
        dfs.dfs(start);
        System.out.println();
        bfs.bfs(start);
        sc.close();
    }
}
