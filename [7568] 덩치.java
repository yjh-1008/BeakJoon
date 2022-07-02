import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] arr;
    static class info{
        int weight;
        int height;
        info(int w, int h){
            this.weight = w;
            this.height = h;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        ArrayList<info> arr =  new ArrayList<>();
        for(int i=0;i<s;i++){
            String str =  br.readLine();
            int w =Integer.parseInt(str.split(" ")[0]);
            int h = Integer.parseInt(str.split(" ")[1]);
            arr.add(new info(w,h));
        }
        br.close();
        int count;
        for(int i=0;i<s;i++){
            count=1;
            info a = arr.get(i);
            for(int j=0;j<s;j++){
                if( i != j&&a.weight < arr.get(j).weight && a.height < arr.get(j).height){
                    count++;
                }
            }
            System.out.print(count+" ");
        }
    }
}