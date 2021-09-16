import java.util.Scanner;

public class Main {
    static long[] arrA=new long[100];
    static long[] arrB=new long[100];
    static long fibo(long[]arr, int N){
        if(N==0){
            return arr[0];
        }else if(N==1){
            return arr[1];
        }
        if(arr[N]>0){
            return arr[N];
        }
        return arr[N]=fibo(arr,N-1)+fibo(arr,N-2);
    }
    static public void main(String[] args){
       Scanner sc= new Scanner(System.in);
       int N=sc.nextInt();
       arrA[0]=0;
       arrA[1]=arrB[1]=arrB[0]=1;
       long a=fibo(arrA,N-1);
       long b=fibo(arrB,N-1);
       System.out.print(a+" "+b);
    }
}
