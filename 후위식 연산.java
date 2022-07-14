import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char str[] = sc.next().toCharArray();
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        int a;
        int b;
        for(char c: str){
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }else{
                switch(c){
                    case '+':

                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b+a);
                        break;
                    case '-':
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b-a);
                        break;
                    case '*':
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b*a);
                        break;
                    case '/':
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b/a);
                        break;
                }
            }
        }
        System.out.println(stack.peek());
    }
}

//3 5 2