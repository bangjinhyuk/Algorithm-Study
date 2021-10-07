import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/10/07.
 */
public class BOJ_1463 {
    static int [] dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        for(int i=2;i<n+1;i++) dp[i] = -1;
        System.out.println(makeOne(n));
    }

    private static int makeOne(int n) {
        if(dp[n] == -1){
            if(n%3 ==0 && n%2 ==0){
                dp[n] = Math.min(makeOne(n/3),Math.min(makeOne(n/2),makeOne(n-1)))+1;
            }else if (n%3 ==0 && n%2 !=0){
                dp[n] = Math.min(makeOne(n/3),makeOne(n-1))+1;

            }else if (n%3 !=0 && n%2 ==0){
                dp[n] = Math.min(makeOne(n/2),makeOne(n-1))+1;
            }else{
                dp[n] = makeOne(n-1)+1;
            }
        }
        return dp[n];
    }
}
