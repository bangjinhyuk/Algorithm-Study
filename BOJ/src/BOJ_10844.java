import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bangjinhyuk on 2021/10/08.
 */
public class BOJ_10844 {
    static long [][] dp;
    static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        dp = new long[n][10];
        for(int i=1;i<10;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        long sum = 0;
        for(int i=0;i<10;i++) {
            sum += getStairNum(n, i)%mod;
        }
        System.out.println(sum%mod);
    }

    private static long getStairNum(int n, int num) {
        if(dp[n-1][num]==-1){
            if (num == 0) dp[n-1][num] = getStairNum(n-1,num+1);
            else if(num ==9) dp[n-1][num] = getStairNum(n-1,num-1);
            else dp[n-1][num] = (getStairNum(n-1,num+1)+getStairNum(n-1,num-1));
        }
        dp[n-1][num] %=mod;
        return dp[n-1][num];
    }
}
