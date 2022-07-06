import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int lt=0;
        int rt=0;
        while(lt<arr1.length && rt<arr2.length){
            if(arr1[lt]==arr2[rt]){
                answer.add(arr1[lt]);
                lt++;
                rt++;
            }else if(arr1[lt] < arr2[rt]){
                lt++;
            }else{
                rt++;
            }
        }
        for(int a: answer){
            System.out.print(a+" ");
        }
    }
    //1 2 3 5 9
    //2 3 5 7 8
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for(int i=0;i<N;i++){
            arr1[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i=0;i<M;i++){
            arr2[i] = sc.nextInt();
        }
        solution(arr1, arr2);
    }
}