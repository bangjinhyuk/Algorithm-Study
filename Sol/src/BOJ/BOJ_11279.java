package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by bangjinhyuk on 2021/11/15.
 */
public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
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
