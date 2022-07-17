import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue =  new LinkedList<>();
        for(String s: sc.nextLine().split("")){
            queue.offer(s);
        }
        String[] schedule = sc.nextLine().split("");
        String answer = "YES";
        for(String s : schedule){
            if(queue.contains(s)){
                if(!queue.peek().equals(s)){
                    answer="NO";
                    break;
                }else{
                    queue.poll();
                }
            }
        }
        if(!queue.isEmpty()) answer="NO";
        System.out.print(answer);


    }
}

//3 5 2