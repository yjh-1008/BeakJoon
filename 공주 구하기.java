import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(char[] str){
        int answer=0;
        int stick=0;
        Stack<Character> stack = new Stack<>();
        for(char c :str){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            switch(c){
                case '(':
                    if(stack.peek()=='('){
                        stick++;
                    }
                    stack.push(c);
                    break;
                case ')':
                    if(stack.peek()=='('){ //레이저
                        answer += stick;
                    }else if(stack.peek()==')'){//쇠막대기
                        answer+=1;
                        stick--;
                    }
                    stack.push(c);
                    break;
            }
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.offer(i);
        }
        int tmp=1;
        while(queue.size()>1){
            if(tmp%k != 0){
                queue.offer(queue.poll());
            }else{
                queue.poll();
            }
            tmp++;
        }
        System.out.print(queue.poll());
    }
}

//3 5 2