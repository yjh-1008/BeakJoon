import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static int lower_case(int[]arr, int temp){

        int lt=0, rt=arr.length;
        while(lt<rt){
            int mid=lt+(rt-lt)/2;
            if(temp<=arr[mid]){
                rt=mid;
            }else{
                lt=mid+1;
            }
        }
        return lt;
    }

    public static int higher_case(int[]arr, int temp){
        int lt=0, rt=arr.length;
        while(lt<rt){
            int mid=lt+(rt-lt)/2;
            if(temp>=arr[mid]){
                lt=mid+1;
            }else{
                rt=mid;
            }
        }
        return lt;
    }

    //-10 -10 2 3 3 6 7 10 10 10
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int arr1[] = new int[N];
        for(int i=0;i<N;i++){
            arr1[i]=sc.nextInt();
        }
        int M= sc.nextInt();
        Arrays.sort(arr1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<M;i++){
            int temp=sc.nextInt();
            int lo= lower_case(arr1,temp);
            int hi=higher_case(arr1,temp);
            int answer=hi-lo;
            bw.append(answer+" ");
        }
        bw.flush();
        bw.close();

    }
}
