package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/05/10.
 */
public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Thing> things = new ArrayList<>();
        int totalWeight = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            things.add(new Thing(w, v));
            totalWeight += w;
        }

        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < k+1; j++) {
                if(j < things.get(i-1).weight)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-things.get(i-1).weight] + things.get(i-1).happy);
            }
        }
        System.out.println(dp[n][k]);

    }

    private static class Thing {
        int weight;
        int happy;

        public Thing(int weight, int happy) {
            this.weight = weight;
            this.happy = happy;
        }
    }
}
