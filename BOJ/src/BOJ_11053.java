import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/09.
 */
public class BOJ_11053 {
    static int [] numbers;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        numbers = new int[n+1];
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        numbers[0] = 1001;
        for(int i = 1;i<n+1;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        getDp(n);
        Arrays.sort(dp);
        System.out.println(dp[n]);

    }

    private static int getDp(int n) {
        if(dp[n] ==-1){
            int result;
            boolean flag = false;
            for(int i = n-1;i>=0;i--){
                if(numbers[n]>numbers[i]){
                    result = getDp(i)+1;
                    flag = true;
                    if(dp[n]<result) dp[n] = result;
                }else getDp(i);
            }
            if(!flag) {
                dp[n] =1;
                getDp(n-1);
            }
        }
        return dp[n];

    }
}
