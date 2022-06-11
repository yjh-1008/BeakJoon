import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int answer=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }else{
                stack.pop();
                if(str.charAt(i-1)=='('){
                   answer += stack.size();
                }else{
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }
}
