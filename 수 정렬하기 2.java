import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        //quickSort(arr);
        for(int a: arr){
            sb.append(a).append('\n');
        }
        System.out.println(sb);
    }
}