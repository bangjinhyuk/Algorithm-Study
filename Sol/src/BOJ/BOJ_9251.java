package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/11/11.
 */
public class BOJ_9251 {
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var s1 = br.readLine();
        var s2 = br.readLine();
        dp = new int[s1.length()+1][s2.length()+1];
        int max = 0 ;
        for(int i =1;i<=s1.length();i++){
            for(int j =1;j<=s2.length();j++){
                if(String.valueOf(s1.charAt(i-1)).equals(String.valueOf(s2.charAt(j-1)))){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if(max< dp[i][j]) max = dp[i][j];
            }
        }

        System.out.println(max);
    }
}
