import java.util.ArrayList;
import java.util.Scanner;

class Main{
    static int answer=0;
    public static void hanNum(String num){
        String[] arr = num.split("");//각 자릿수를 배열로 저장
        if(arr.length==1){//일의 자리 숫자는 이미 한수이므로 검사할 필요 x
            answer++;
        }else if(arr.length>1){
            int temp = Integer.parseInt(arr[0])-Integer.parseInt(arr[1]);
            for(int i=1;i<arr.length-1;i++){
                if(temp != Integer.parseInt(arr[i])- Integer.parseInt(arr[i+1])) {
                    return;
                }
            }
            answer++;
        }
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       for(int i=1;i<=N;i++){
           hanNum(Integer.toString(i));
       }
       System.out.println(answer);
    }
}