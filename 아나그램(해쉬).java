import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(String[] str1, String[] str2){
        HashMap<String, Integer> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();
        boolean answer=true;
        for(String s: str1){
            hash1.put(s, hash1.getOrDefault(s, 0)+1);
        }

        for(String s: str2){
            hash2.put(s, hash2.getOrDefault(s, 0)+1);
        }

        for(String s: hash1.keySet()){
            if(hash1.get(s) != hash2.get(s)){
                answer=false;
                break;
            }
        }
        System.out.println(answer?"YES":"NO");

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str1[] = sc.nextLine().split("");
        String str2[] = sc.nextLine().split("");
        solution(str1,str2);
    }
}