import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int R;
    static int C;
    static char[][] map;
    static int[][] moveMap;
    static int[] toX = {0,0,-1,1};
    static int[] toY = {1,-1,0,0};
    static class Point{
        int x;
        int y;
        char type;
        Point(int x, int y,char type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        Point sPoint=null;
        //물과 비버의 위치를 가져옴
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]=='*'){
                    queue.offer(new Point(i,j,'*'));
                }else if(map[i][j]=='S'){
                    sPoint = new Point(i,j,'S');
                }
            }
        }
        queue.offer(sPoint);
        while(!queue.isEmpty()){
            //큐에서 꺼내옴
            Point point = queue.poll();
            //목적지인가 = 비버의 집이거나 (물가 혹은 돌)
            if(point.type=='D'){
                System.out.print(moveMap[point.x][point.y]);
                return;
            }
            //연결된 곳을 순회
            for(int i=0;i<4;i++){
                int moveX = point.x+toX[i];
                int moveY = point.y+toY[i];
                //갈 수 있는가
                if(moveX<R && moveY<C && moveX>=0 && moveY>=0){ //1.지도 범위 내
                    //고슴도치
                    if(point.type=='S' || point.type=='.'){
                        if((map[moveX][moveY]=='.' || map[moveX][moveY]=='D') && moveMap[moveX][moveY]==0){
                            //체크인
                            moveMap[moveX][moveY] = moveMap[point.x][point.y]+1;
                            //큐에 넣음
                            queue.offer(new Point(moveX, moveY,map[moveX][moveY]));
                        }
                    }else if(point.type=='*'){
                        if(map[moveX][moveY]=='.' || map[moveX][moveY]=='S'){
                            map[moveX][moveY] = '*';
                            //큐에 넣음
                            queue.offer(new Point(moveX, moveY,'*'));
                        }
                    }
                }
            }
        }
        System.out.print("KAKTUS");
    }
    //.는 비어있는 곳, *은 물이 차있음, 돌은 X, 비버굴 D, 고슴도치 S
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        map = new char[R][C];
        moveMap = new int[R][C];
        for(int i=0;i<R;i++){
            str = br.readLine().split("");
            for(int j=0;j<C;j++){
                map[i][j] = str[j].charAt(0);
            }
        }

        bfs();

    }
}

//3 5 2