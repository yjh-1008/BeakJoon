import java.util.Scanner;

public class Main {
    static int[][] arr;
    public static void makePascal(int[][]arr){
        int count=1;
        arr[0][0]=1;
        for(int i=1;i<arr.length;i++){
            arr[i][0]=1;
            arr[i][arr.length-1]=1;
            for(int j=1;j<arr.length;j++){
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            }
        }
    }

    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       int R= sc.nextInt();
       int C=sc.nextInt();
       int W= sc.nextInt();
       arr=new int[R+W-1][R+W-1];
       makePascal(arr);
        int sum=0;//합을 넣을 변수
        int count=0;
        for(int i=R-1;i<arr.length;i++){

            for(int j=C-1;j<C+count;j++){
                sum+=arr[i][j];
            }
            count++;
        }
        System.out.println(sum);
    }
}