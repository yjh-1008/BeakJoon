import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int money=sc.nextInt();
       int year= sc.nextInt();
       int dp[]= new int[year+1];
       dp[0]=money;
       for(int i=1;i<=year;i++){
           dp[i]=(int)Math.floor(dp[i-1]*1.05);
           if(i>=3){
               dp[i]=(int)Math.max(dp[i],Math.floor(dp[i-3]*1.2));
           }
           if(i>=5){
               dp[i]=(int)Math.max(dp[i],(int)Math.floor(dp[i-5]*1.35));
           }
       }
       System.out.println(dp[year]);
    }
}