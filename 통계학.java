import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static long arithmeticMean(int[] arr, int n){
        double sum=0;
        for(int a: arr){
            sum+=a;
        }
        return (long)Math.round((sum/n));
    }
    public static int middleNum(int[] arr){
        Arrays.sort(arr);
        int middle = arr.length/2;

        return arr[middle];
    }
    public static int mode(int[]arr){
        int tempArr[] = new int[8001];
        int temp = Integer.MIN_VALUE;
        int count=0;
        ArrayList<Integer> modeArr = new ArrayList<>();
        for(int a: arr){
            if(a<0){
                tempArr[4000+(-1*a)]++;
            }else{
                tempArr[a]++;
            }
        }
        //가장 높은 빈도수 찾기
        for(int i=0;i<8001;i++){
            if(temp<tempArr[i]){
                temp=tempArr[i];
            }
        }

        int max=-1;
        //같은 최빈값을 찾기
        for(int i=0;i<8001;i++){
            if(temp==tempArr[i]){

                if(i>4000){
                    modeArr.add(4000-i);
                }else{
                    modeArr.add(i);
                }
            }
        }
        Collections.sort(modeArr);
        if(modeArr.size()==1){
            return modeArr.get(0);
        }
        return modeArr.get(1);
    }
    public static int range(int []arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a:arr){
           if(max<a){
               max=a;
           }
           if(min>a){
               min=a;
           }
        }
        if((max>0 && min>0) || (max<0 && min<0)){
            return Math.abs(max-min);
        }
        return Math.abs(min)+Math.abs(max);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        sb.append(arithmeticMean(arr,N)).append('\n');
        sb.append(middleNum(arr)).append('\n');
        sb.append(mode(arr)).append('\n');
        sb.append(range(arr)).append('\n');
        System.out.println(sb);



    }
}