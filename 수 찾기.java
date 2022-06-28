import java.util.*;

class Main {
    public static int solution(int N, int[] arr, int temp){
        int answer=0;
        int lt=0 ,rt=N-1;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(arr[lt]==temp|| arr[rt]==temp||arr[mid]==temp){
                answer=1;
                break;
            }
            if(arr[mid]>=temp){
                rt=mid-1;
            }else{
                lt=mid+1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int arr1[] = new int[N];
        for(int i=0;i<N;i++){
            arr1[i]=sc.nextInt();
        }
        int M= sc.nextInt();
        int answer[]=new int[M];
        Arrays.sort(arr1);
        for(int i=0;i<M;i++){
            int temp=sc.nextInt();
            answer[i]=solution(N,arr1,temp);
        }
        for(int x:answer){
            System.out.println(x);
        }


    }
}
