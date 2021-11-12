package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/11/12.
 */
public class BOJ_11000 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Class> pq = new PriorityQueue<>();
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        for(int i = 0;i < n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            pq.add(new Class(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Integer> room = new PriorityQueue<>();

        while(!pq.isEmpty()) {
            if(!room.isEmpty() && room.peek()<=pq.peek().s){
                room.poll();
            }
            room.offer(pq.poll().t);
        }
        System.out.println(room.size());
    }
    static class Class implements Comparable<Class> {
        int s;
        int t;

        public Class(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Class o) {
            if(this.s == o.s) return this.t-o.t;
            else return this.s - o.s;
        }
    }
}
