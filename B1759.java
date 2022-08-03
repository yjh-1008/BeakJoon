import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int L;
    static int C;
    static boolean visited[];
    static char characters[];
    static int count=0;
    static int answer=0;
    public static void validation(){
        //자음과 모음의 갯수를 검사
        int consonantNum =0;
        int collectionNum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<C;i++){
            if(visited[i]){
                sb.append(characters[i]);
                if(characters[i]=='a'
                        || characters[i]=='e'
                        || characters[i]=='i'
                        ||characters[i]=='o'
                        || characters[i]=='u'){
                    collectionNum++;
                }else consonantNum++;
            }
        }
        if(collectionNum>=1 && consonantNum>=2){
            System.out.println(sb);
        }

    }

    public static void dfs(int index){
        //체크인
        visited[index]=true;
        count++;
        //목적지 = 길이가 L이고 모음 최소 1개와 자음 최소 2개
        if(count==L){
            validation();
        }else{
            //연결된 곳
            for(int t=index+1;t<C;t++){
                // 갈 수 있는가
                if(!visited[t]){
                    dfs(t);// 간다
                }
            }
        }

        //체크아웃
        visited[index]=false;
        count--;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        characters = new char[C];
        for(int i=0;i<C;i++) {
            characters[i] = sc.next().charAt(0);
        }

        visited = new boolean[C];
        Arrays.sort(characters);
        for(int i=0;i<C;i++){
            dfs(i);
        }
    }
}

//3 5 2