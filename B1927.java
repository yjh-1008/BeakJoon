package DAY03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1927 {
    static int N;
    static List<Integer> list;
    public static int remove(){
        //부모노드를 빼옴
        int remove = list.get(1);
        int p = list.size()-1;
        list.set(1, list.get(p));
        list.remove(p);

        int len=1;
        while (len*2 < list.size()) {
            int min = list.get(len*2);
            int minIdx = len*2;

            if(((len*2+1)<list.size() && min > list.get(len*2+1))){
                min = list.get(len*2+1);
                minIdx = len*2+1;
            }
            if(list.get(len)<min){
                break;
            }
            swap(len,minIdx);
            len=minIdx;
        }
        return remove;
    }
    public static void insert(int n){
        //맨 끝에 삽입
        list.add(n);
        //루트노드까지 비교
        int len = list.size()-1;
        while(len>1 && list.get(len)< list.get(len/2)){
            //비교
            swap(len,len/2);
            len=len/2;
        }
    }
    public static void swap(int c, int p){
        int tmp = list.get(c);
        list.set(c,list.get(p));
        list.set(p,tmp);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(0);
        for(int i=0;i<N;i++){
            int order = Integer.parseInt(br.readLine());
            //삭제 명령
            if(order == 0){
                //list가 비어있다면 0을 출력
                if(list.size()==1) System.out.println(0);
                //비어있지 않다면 삭제 연산 수행
                else System.out.println(remove());
            }
            //삽입 명령
            else{
                insert(order);
            }
        }
    }
}
