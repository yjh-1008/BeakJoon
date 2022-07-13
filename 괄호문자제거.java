import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack<String> answer = new Stack<>();
        String[] str = sc.next().split("");
        StringBuilder sb = new StringBuilder();
        for(String s: str){
            if(s.equals("(")){
                answer.push(s);
            }else if(s.equals(")")){
                answer.pop();
            }else{
                if(answer.size()<=0){
                    sb.append(s);
                }
            }
        }
        System.out.print(sb);

    }
}