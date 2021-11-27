package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11060 {
    static int [] dp;
    static int [] miro;
    static int n;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        miro = new int[n];
        dp = new int[n];
        Arrays.fill(dp,-1);
        dp[n-1] = 0;
        for(int i = 0; i < n; i++){
            miro[i] = Integer.parseInt(st.nextToken());
        }
        int result = getDp(0);
        System.out.println(result);
    }

    private static int getDp(int idx) {
        if(dp[idx] == -1){
            int getMin = Integer.MAX_VALUE;
            for(int i = 1;i<=miro[idx]; i++){
                if(idx + i<n) {
                    int tmp = getDp(idx + i);
                    if (tmp < getMin && tmp != -1) getMin = tmp;
                }
            }
            if(getMin !=101) return dp[idx] = getMin+1;
        }
        return dp[idx];
    }
}