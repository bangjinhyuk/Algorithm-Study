package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/16.
 */
public class BOJ_1010 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        var br= new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        for(int i = 0;i<t;i++){
            var st = new StringTokenizer(br.readLine()," ");
            var n = Integer.parseInt(st.nextToken());
            var m = Integer.parseInt(st.nextToken());
            if(n>m) sb.append(getNum(n,m)).append("\n");
            else sb.append(getNum(m,n)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getNum(int max, int min) {
        if(max == min || min == 0) {
            return dp[max][min] = 1;
        }
        if(dp[max][min] > 0) {
            return dp[max][min];
        }else return dp[max][min] = getNum(max - 1, min - 1) + getNum(max - 1, min);
    }
}
