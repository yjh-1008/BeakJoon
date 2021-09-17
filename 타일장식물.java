import java.util.Scanner;

public class Main {
    static public void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        long[] round=new long[81];
        round[0]=4;
        round[1]=6;
        for(int i=2;i<N;i++){
            round[i]=round[i-1]+round[i-2];
        }
        System.out.print(round[N-1]);
    }
}
