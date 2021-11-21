package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by bangjinhyuk on 2021/11/21.
 */
public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)== Math.abs(o2)) return o1-o2;
                else return Math.abs(o1) - Math.abs(o2);
            }
        });
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int method = Integer.parseInt(br.readLine());
            if(method == 0 && !priorityQueue.isEmpty()){
                sb.append(priorityQueue.poll()).append("\n");
            }else if(method == 0) sb.append(0).append("\n");
            else priorityQueue.offer(method);
        }
        System.out.println(sb);
    }
}
