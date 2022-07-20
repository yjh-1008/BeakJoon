package DAY03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1202 {
    static int N;
    static int K;
    static int[] bags;
    static ArrayList<Jewel> jewels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bags = new int[K];
        jewels = new ArrayList<>();
        PriorityQueue<Integer> jewelsQ = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        for(int i=0;i<K;i++){
            bags[i]=(Integer.parseInt(br.readLine()));

        }
        //가방 정렬
        Arrays.sort(bags);
        //보석을 무게 오름차순으로 정렬
        Collections.sort(jewels);

        //가방에 보석을 담는다.
        int jewelIdx=0;
        long sum=0;
        for(int i=0;i<K;i++){
            int bag = bags[i];
            while(jewelIdx<N && bag>= jewels.get(jewelIdx).m){
                    jewelsQ.offer( jewels.get(jewelIdx++).v);
            }
            if(!jewelsQ.isEmpty()) sum += jewelsQ.poll();

        }
        System.out.print(sum);
    }
}
class Jewel implements Comparable<Jewel>{
    int m;
    int v;
    Jewel(int m, int v){
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Jewel o) {
        return this.m-o.m;
    }
}
