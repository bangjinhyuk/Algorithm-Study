package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/06.
 */
public class BOJ_1149 {
    static List<color> colors = new ArrayList<>();
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        for(int i =0;i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            colors.add(new color(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        dp[0][0] = colors.get(0).red;
        dp[0][1] = colors.get(0).green;
        dp[0][2] = colors.get(0).blue;
        System.out.println(Math.min(getMinCost(n-1,0),Math.min(getMinCost(n-1,1),getMinCost(n-1,2))));

    }

    private static int getMinCost(int n, int colorIdx) {
       if(dp[n][colorIdx] ==0){
           if(colorIdx ==0) dp[n][0] = Math.min(getMinCost(n-1,1),getMinCost(n-1,2))+colors.get(n).red;
           else if(colorIdx ==1) dp[n][1] = Math.min(getMinCost(n-1,0),getMinCost(n-1,2))+colors.get(n).green;
           else dp[n][2] = Math.min(getMinCost(n-1,0),getMinCost(n-1,1))+colors.get(n).blue;
       }

       return dp[n][colorIdx];
    }

    public static class color{
        int red;
        int green;
        int blue;

        public color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }
}
