package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/12.
 */
public class BOJ_1781 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        PriorityQueue<Question> queue = new PriorityQueue<>(new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                if(o1.deadline == o2.deadline) return o2.num - o1.num;
                else return o1.deadline - o2.deadline;
            }
        });
        for(int i = 0;i<n;i++){
            var st = new StringTokenizer(br.readLine(), " ");
            queue.offer(new Question(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Question> queue2 = new PriorityQueue<>(new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                return o1.num - o2.num;
            }
        });

        int time = 0, Ramen=0;
        while(!queue.isEmpty()){
            if(queue.peek().deadline>time){
                time++;
                queue2.offer(queue.poll());
            }else{
                if(!queue2.isEmpty() && queue2.peek().num<queue.peek().num){
                    queue2.poll();
                    queue2.offer(queue.poll());
                }else queue.poll();
            }
        }
        for(Question q : queue2) {
            Ramen += q.num;
        }
        System.out.println(Ramen);
    }
    static class Question{
        int deadline;
        int num;

        public Question(int deadline, int num) {
            this.deadline = deadline;
            this.num = num;
        }
    }
}
