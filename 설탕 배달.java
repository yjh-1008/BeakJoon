import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //설탕의 무게
        int answer=Integer.MAX_VALUE;
        boolean chk = false;
        if(N%5==0){
            System.out.println(N/5);
            return;
        }
        int i=1;
        while(i*5<=N){
            int tmp = N-(i*5);
            if(tmp %3 ==0){
                answer = Math.min(answer, i+(tmp/3));
                chk = true;
            }
            i++;
        }
        if(N%3==0){
            answer = Math.min(answer, N/3);
            chk =true;
        }
        if(chk){

            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
    }
}

//3 5 6 8 9 10 11 12 13 14 15 16 17
//8+3n
//8+5n