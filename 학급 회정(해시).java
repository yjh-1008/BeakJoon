import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(){

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<String, Integer> hash = new HashMap<>();
        String[] str = sc.next().split("");
        for(int i=0;i<str.length;i++){
            hash.put(str[i], hash.getOrDefault(str[i],0)+1);
        }
        String answer="";
        int tmp=-1;
        for(String s: hash.keySet()){
            if(tmp< hash.get(s)){
                tmp=hash.get(s);
                answer=s;
            }
        }
        System.out.print(answer);
    }
}