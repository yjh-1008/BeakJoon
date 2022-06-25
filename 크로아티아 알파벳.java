import java.util.ArrayList;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] str= {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String strs = sc.nextLine();
        for(String s : str){
            if(strs.contains(s)){
                strs=strs.replace(s,"!");
            }
        }
        System.out.println(strs.length());
    }
}