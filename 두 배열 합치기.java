import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void solution(int[] arr1, int [] arr2){
        int pointer1=0, pointer2=0;
        ArrayList<Integer> answer = new ArrayList<>();
        while(true){
            if(pointer1>= arr1.length && pointer2>= arr2.length){
                break;
            }else if(pointer1>= arr1.length && pointer2< arr2.length){
                for(int i=pointer2;i<arr2.length;i++){
                    answer.add(arr2[i]);
                    pointer2++;
                }
                continue;
            }else if(pointer1< arr1.length && pointer2>= arr2.length){

                for(int i=pointer1;i<arr1.length;i++){
                    answer.add(arr1[i]);
                    pointer1++;
                }
                continue;
            }else{
                if(arr1[pointer1]> arr2[pointer2]){
                    answer.add(arr2[pointer2]);
                    pointer2++;
                }else if(arr1[pointer1]< arr2[pointer2]){
                    answer.add(arr1[pointer1]);
                    pointer1++;
                }else{
                    answer.add(arr2[pointer2]);
                    pointer2++;
                    answer.add(arr1[pointer1]);
                    pointer1++;
                }
            }
            continue;
        }
        for(int a: answer){
            System.out.print(a+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        String str = br.readLine();
        for(int i=0;i<N;i++){
            arr1[i] = Integer.parseInt(str.split(" ")[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        str = br.readLine();
        for(int i=0;i<M;i++){
            arr2[i] = Integer.parseInt(str.split(" ")[i]);
        }
        solution(arr1, arr2);
    }
}