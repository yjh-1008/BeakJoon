import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int count=0;
        int deathNum=666;
        while(count!=N){
            String s = Integer.toString(deathNum);
            if(s.contains("666")){
                //System.out.println(s);
                count++;
            }
            if(count==N){
                System.out.println(deathNum);
                return;
            }
            deathNum++;
        }

    }
}