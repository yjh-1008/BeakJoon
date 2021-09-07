import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
class Main {
    static public class Point {
        private int x;
        private int y;
        private int des = 0;

        Point(int x, int y, int des) {
            this.x = x;
            this.y = y;
            this.des = des;
        }
    }

    static int[] toX = { -1, -2, -2, -1, 1, 2, 2, 1 }, toY = { -2, -1, 1, 2, -2, -1, 1, 2 };

    static int bfs(Point start, Point des, int width) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] chk = new boolean[width][width];
        chk[start.x][start.y] = true;
        q.add(start);
        Point temp;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.x == des.x && temp.y == des.y) {
                return temp.des;
            }
            for (int i = 0; i < 8; i++) {
                int dx = temp.x + toX[i];
                int dy = temp.y + toY[i];

                // 범위가 벗어날 경우
                if (dx < 0 || dy < 0 || dx >= chk.length || dy >= chk.length) {
                    continue;
                }

                if (!chk[dx][dy]) {
                    chk[dx][dy] = true;
                    q.offer(new Point(dx, dy, temp.des + 1));
                }
            }
        }
        return 0;
    }



    static public void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int n=sc.nextInt();
        for(int i=0;i<n;i++) {
            int width = sc.nextInt();
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int desX = sc.nextInt();//목적지의 x좌표
            int desY = sc.nextInt();//목적지의 y좌표
            Point start = new Point(startX, startY, 0);
            Point des = new Point(desX, desY, 0);
            sb.append(bfs(start, des, width) + "\n");

        }
        System.out.print(sb.toString());
    }
}
