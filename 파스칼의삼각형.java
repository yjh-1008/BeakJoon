import java.util.Scanner;

public class Main {
    static long arr[][];
    static public void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        arr=new long[N][N];
        arr[0][0]=1;
        for(int i=1;i<N;i++){
            arr[i][0]=1;
            arr[i][N-1]=1;
            for(int j=1;j<N-1;j++){
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            }
        }
        System.out.println(arr[N-1][M-1]);
    }
}
