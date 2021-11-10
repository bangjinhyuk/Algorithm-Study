package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/11/09.
 */
public class BOJ_2565 {
    static int[] dp;
    static List<Line> lines;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        lines = new ArrayList<>();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 0;i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            lines.add(new Line(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        lines.sort(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                if(o1.right!=o2.right) return o1.right-o2.right;
                else return o1.left-o2.left;
            }
        });

        getDp(1);
        int max = 0;
        for(int i:dp) {
            if(max<i) max = i;
        }
        System.out.println(n-max);

    }

    private static void getDp(int idx) {
        if(idx >lines.size()) return;
        if(dp[idx] == -1){
            int max = 0;
            for(int i=0;i<idx;i++){
                if(lines.get(idx-1).left >= lines.get(i).left) {
                    max = Math.max(max,dp[i+1]);
                }
            }
            dp[idx] = max+1;
        }getDp(idx+1);
    }

    static class Line{
        int line;
        int left;
        int right;

        @Override
        public String toString() {
            return "Line{" +
                    "line=" + line +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public Line(int line, int left, int right) {
            this.line = line;
            this.left = left;
            this.right = right;
        }
    }
}
