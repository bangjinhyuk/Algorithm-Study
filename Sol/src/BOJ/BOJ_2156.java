import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/10/08.
 */
public class BOJ_2156 {
    static int [] cup;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        cup = new int[n+1];
        for(int i=1;i<n+1;i++){
            dp[i] = -1;
        }
        for(int i=1;i<n+1;i++){
            cup[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = cup[1];
        System.out.println(getMax(n));
    }

    private static int getMax(int n) {
        if(n == 0) return 0;
        if(dp[n]==-1){
            if(n>2){
                dp[n] = Math.max(Math.max(getMax(n-2),(getMax(n-3)+cup[n-1]))+cup[n],getMax(n-1));
            }
            else dp[n] = cup[n-1]+cup[n];
        }
        return dp[n];
    }
}
