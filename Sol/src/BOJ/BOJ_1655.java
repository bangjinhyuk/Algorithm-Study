package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/01/08.
 */
public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();

        PriorityQueue<Integer> lPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rPriorityQueue = new PriorityQueue<>();

        rPriorityQueue.add(Integer.parseInt(br.readLine()));
        n--;
        sb.append(rPriorityQueue.peek()).append("\n");

        while(n-->0){
            int tmp = Integer.parseInt(br.readLine());
            if(rPriorityQueue.peek()>tmp)
                lPriorityQueue.add(tmp);
            else
                rPriorityQueue.add(tmp);

            if(rPriorityQueue.size() - lPriorityQueue.size() > 1)
                lPriorityQueue.add(rPriorityQueue.poll());
            else if(lPriorityQueue.size() - rPriorityQueue.size() > 1)
                rPriorityQueue.add(lPriorityQueue.poll());

            if(rPriorityQueue.size() == lPriorityQueue.size())
                sb.append(Math.min(rPriorityQueue.peek(), lPriorityQueue.peek())).append("\n");
            else if(rPriorityQueue.size() > lPriorityQueue.size())
                sb.append(rPriorityQueue.peek()).append("\n");
            else
                sb.append(lPriorityQueue.peek()).append("\n");
        }

        System.out.println(sb);

    }
}
