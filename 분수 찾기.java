import java.util.ArrayList;
import java.util.Scanner;

class Main{

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();

        int temp=1;//등차수열의 합
        int sum=0;
        while(sum+temp<N){
            sum = sum +temp;
            temp++;
        }
        int a;
        int b ;
        if(temp%2==0){//분모가 작아지고 분자가 커짐
            a=temp;
            b=1;
            for(int i=1;i<N-sum;i++){
                a--;
                b++;
            }
        }else{
            a=1;
            b=temp;
            for(int i=1;i<N-sum;i++){
                a++;
                b--;
            }
        }
        //1+2+3+4+5;
        System.out.println(b+"/"+a);
    }
}