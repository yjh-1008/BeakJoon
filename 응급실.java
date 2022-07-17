import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person{
    int id;
    int priority;
    Person(int id, int priority){
        this.id = id;
        this.priority =priority;
    }
}
class Main {

    public static void solution(Queue<Person> queue, int n, int m){
        int count = 1;
        while(true) {
            Person tmp = queue.poll();
            for(Person p : queue){
                if(tmp.priority < p.priority){
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                if(tmp.id == m){
                    System.out.println(count);
                    return;
                }
                else count++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Queue<Person> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            queue.add(new Person(i, sc.nextInt()));
        }
        //80 90 60 50 70 5
        solution(queue,N,M);
    }
}

//3 5 2