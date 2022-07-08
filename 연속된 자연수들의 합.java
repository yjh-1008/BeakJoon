import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(int n){
        int answer=0;
        for(int i=1;i<=n/2+1;i++){
            int sum=i;
            for(int j=i+1;j<=n/2+1;j++){
                sum+=j;
                if(sum==n){
                    answer++;
                    break;
                }else if(sum>n){
                    break;
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solution(N);


    }
}