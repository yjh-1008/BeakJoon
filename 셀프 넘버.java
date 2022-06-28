import java.util.ArrayList;
import java.util.Scanner;

class Main{
    public static int div(int i){
       int sum = i;
       while(i %10 !=0){
           sum += i%10;
           i=i/10;
       }
       return sum;
    }
    public static void main(String[] args) {
        boolean []chk = new boolean[10001];
        for(int i=1;i<10001;i++){
            System.out.println(div(i));
            int s = div(i);
            //System.out.println(s);
            if(s<=10000 &&!chk[s]){
                chk[s] = true;
            }
        }
        for(int i=1;i<10001;i++){
            if(!chk[i]){
                System.out.println(i);
            }
        }
    }
}