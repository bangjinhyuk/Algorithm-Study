package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/02/04.
 */
public class BOJ_15810 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Staff> queue = new PriorityQueue<>();
        while(n-->0){
            int num = Integer.parseInt(st.nextToken());
            queue.add(new Staff(num,num));
        }
        int result = 0;
        Staff tmp = null;
        while(result<m){
            tmp = queue.poll();
            queue.add(new Staff(tmp.originTime,tmp.tmpTime+(long)tmp.originTime));
            result++;
        }
        if(tmp == null)
            System.out.println(0);
        else
            System.out.println(tmp.tmpTime);
    }

    private static class Staff implements Comparable<Staff>{
        int originTime;
        long tmpTime;

        public Staff(int originTime, long tmpTime) {
            this.originTime = originTime;
            this.tmpTime = tmpTime;
        }

        @Override
        public int compareTo(Staff o) {
            return (int)(tmpTime - o.tmpTime)%Integer.MAX_VALUE;
        }
    }
}

