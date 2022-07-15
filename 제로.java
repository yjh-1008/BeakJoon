import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum=0;
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                if(!stack.isEmpty()){
                    sum -= stack.pop();
                }
            }else{
                sum+=tmp;
                stack.push(tmp);
            }
        }
        System.out.print(sum);
    }
}

//3 5 2