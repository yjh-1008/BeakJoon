import java.io.*;
import java.util.Scanner;

public class Main {
    static public void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bf.readLine());
        String arr=bf.readLine();
        int count=0;
        for(int i=0;i<N-3;i++){
            String temp;
            if(arr.charAt(i)=='p'){
                temp=arr.substring(i,i+4);
                if(temp.equals("pPAp")){
                    count++;
                    temp="";
                    i+=3;
                }

            }
        }
        System.out.print(count);
        bf.close();
    }
}
