package DAY01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1062 {
    static int N;
    static int K;
    static boolean[] visited = new boolean[26];
    static int answer=0;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //a,n,t,i,c는 기본적으로 있어야하는 문자
        //이 5개보다 k가 작다면 검사 x
        if(K<5){
            System.out.print(0);
            return;
        }
        //visited 1차원 배열에 a,n,t,i,c 인덱스 넣음
        visited['a'-'a']=true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;
        //문자열 받고 anta, tica 잘라내기
        words = new String[N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            str = str.replace("anta","");
            str = str.replace("tica","");
            words[i] = str;
        }

        //dfs로 이동 => 인덱스와 카운트의 수가 들어가야함
        dfs(0,K-5);
        System.out.println(answer);
    }

    public static void dfs(int n, int k){
        //체크인
        visited[n] = true;
        //목적지
        if(k==0){
            int count = 0;
            for(String word: words){
                boolean chk=true;
                for(int i=0;i<word.length();i++){
                    if(!visited[word.charAt(i)-'a']){
                        chk = false;
                        break;
                    }
                }
                if(chk) count++;
            }
            if(answer<count) answer= count;
        }else{
            //연결된 곳을 순회
            for(int i=n+1;i<26;i++){
                //갈 수 있는가?
                if(!visited[i]){
                    //간다
                    dfs(i,k-1);
                }
            }
        }

        visited[n] = false;
    }
}
