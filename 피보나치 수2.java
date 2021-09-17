import java.util.Scanner;

public class Main {
    static long arr[];
    static long fibo(int N){
        if(N==0){
            return 0;
        }else if(N==1){
            return 1;
        }
        if(arr[N]>0){
            return arr[N];
        }
        return arr[N]=fibo(N-1)+fibo(N-2);
    }
    static public void main(String[] args){
       Scanner sc= new Scanner(System.in);
       int N=sc.nextInt();
       arr=new long[N+1];
       arr[0]=0;
       arr[1]=1;
       fibo(N);
       System.out.print(arr[N]);
    }
}
