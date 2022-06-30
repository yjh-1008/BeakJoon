import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int answer=0;
        int N = sc.nextInt(); //설탕의 무게
        for(int i=0;i<N;i++){
            boolean chk=false;
            int tmp = sc.nextInt();
            if(tmp!=1) {
                if (tmp == 2 || tmp == 3) {
                    answer++;
                    continue;
                }
                for (int j = 2; j < tmp; j++) {
                    if (tmp % j == 0) {
                        chk = true;
                        break;
                    }
                }
                if (!chk) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }
}

//3 5 6 8 9 10 11 12 13 14 15 16 17
//8+3n
//8+5n