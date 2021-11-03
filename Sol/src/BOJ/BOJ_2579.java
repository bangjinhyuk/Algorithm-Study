import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/10/07.
 */
public class BOJ_2579 {
    static int [] stairs;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        stairs = new int[n+1];
        dp = new int[n+1];
        stairs[0] = 0;
        for(int i = 1; i<n+1;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1; i<n+1;i++){
            dp[i] = -1;
        }
        System.out.println(getMax(n));

    }

    private static int getMax(int n) {
        if(n<0) return 0;
        if(dp[n] == -1){
            if(n>2) dp[n] = stairs[n] +Math.max(getMax(n-3)+stairs[n-1],getMax(n-2));
            else dp[n] = stairs[n] + getMax(n-1);
        }
        return dp[n];
    }
}
