package DAY11.B1039;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1039 {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
            }else if(order.equals("front")){
                if(q.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    bw.write(q.peek()+"\n");
                }
            }else if(order.equals("back")){
                if(q.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    Object[] arr = q.toArray();
                    bw.write(arr[arr.length-1]+"\n");
                }
            }else if(order.equals("size")){
                bw.write(q.size()+"\n");
            }else if(order.equals("empty")){
                if(q.isEmpty()){
                    bw.write(1+"\n");
                }else{
                    bw.write(0+"\n");
                }
            }else{
                if(q.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    bw.write(q.poll()+"\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
