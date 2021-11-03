import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/06.
 */
public class BOJ_1932 {
    static int [][] dp;
    static int [][] triangle;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        dp = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<i+1;j++){
                dp[i][j] = -1;
            }
        }

        for(int i =0; i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<i+1;j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = triangle[0][0];

        int max=-1;
        for(int i=0;i<n;i++){
            max = Math.max(getMax(n,i),max);
        }
        System.out.println(max);
    }

    private static int getMax(int n, int idx) {

        if(dp[n-1][idx]==-1) {
            if(idx == 0) dp[n - 1][idx] = getMax(n - 1,idx) + triangle[n-1][idx];
            else if(idx == n-1) dp[n - 1][idx] = getMax(n - 1,idx-1) + triangle[n-1][idx];
            else dp[n - 1][idx] = Math.max(getMax(n - 1,idx-1),getMax(n - 1,idx)) + triangle[n-1][idx];
        }
        return dp[n-1][idx];
    }
}
