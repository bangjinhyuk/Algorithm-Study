package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/14.
 */
public class BOJ_1965 {
    static int [] box;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        box = new int[n];

        dp = new int[n];

        for(int i = 0;i < n;i++){
            box[i] = Integer.parseInt(st.nextToken());
        }

        getdp(n-1);
//        for(int i : dp) System.out.println(i);
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }

    private static void getdp(int n) {
        if(dp[n] == 0 ) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                getdp(i);
                if (box[n] > box[i]) {
                    if (dp[i] > max) max = dp[i];
                }
            }
            dp[n] = max + 1;
        }
    }
}
