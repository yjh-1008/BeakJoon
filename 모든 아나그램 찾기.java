import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution( String[] s,String[] t){
        int answer=0;
        HashMap<String, Integer> tHash = new HashMap<>();
        HashMap<String, Integer> sHash = new HashMap<>();
        for(int i=0;i<t.length;i++){
            tHash.put(t[i], tHash.getOrDefault(t[i],0)+1);
            sHash.put(s[i],sHash.getOrDefault(s[i],0)+1);
        }
        if(tHash.equals(sHash)){
            answer++;
        }
        int lt=0;
        for(int rt = t.length; rt<s.length;rt++){
            if(sHash.get(s[lt])-1==0){
                sHash.remove(s[lt]);
            }else{
                sHash.put(s[lt],sHash.get(s[lt])-1);
            }
            lt++;
            sHash.put(s[rt],sHash.getOrDefault(s[rt],0)+1);
            if(tHash.equals(sHash)){
                answer++;
            }
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] S = sc.nextLine().split("");
        String[] T = sc.nextLine().split("");

        solution(S,T);
    }
}