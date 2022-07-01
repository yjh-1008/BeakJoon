import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main{
    public static int k=0;
    private static final StringBuilder answer = new StringBuilder();
    public static void hanoi(int N, int s, int d, int t){//N개의 원반을 s에서 시작해서 t를 거쳐 d로 옮긴다.
        if(N==1){
            answer.append(s).append(" ").append(d).append("\n");
        }else{
            hanoi(N-1, s,t,d);
            answer.append(s).append(" ").append(d).append("\n");
            hanoi(N-1,t,d,s);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        answer.append((int)Math.pow(2,N)-1).append("\n");
        hanoi(N,1,3,2);
        System.out.print(answer);
    }
}

//3 5 6 8 9 10 11 12 13 14 15 16 17
//8+3n
//8+5n