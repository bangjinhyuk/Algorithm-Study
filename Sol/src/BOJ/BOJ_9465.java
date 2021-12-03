package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/03.
 */

/**
 * 왼쪽 세로줄부터 확인
 *
 * 50  10  100  20  40
 * 30  50   70  10  60
 *
 * 가운데 줄 100은 30 또는 50으로 부터 바로 도달 가능, 50 50 100으로 도달 가능 하지만 50 50 100과정에서 중간 50과정은 전줄확인과정에서 이미 dp 최신화 되어있으므로 고려할필요 X
 * 요러한 방식으로 dp 채우기
 */
public class BOJ_9465 {
    static int [][] line, dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            var n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");

            line = new int[2][n];
            for(int j = 0; j < n; j++){
                line[0][j] = Integer.parseInt(st.nextToken());
                line[1][j] = Integer.parseInt(st2.nextToken());
            }

            dp = new int[2][n+1];
            dp[0][1] = line[0][0];
            dp[1][1] = line[1][0];
            for(int j = 2; j <= n; j++){
                dp[0][j] = Math.max(dp[1][j-2],dp[1][j-1])+line[0][j-1];
                dp[1][j] = Math.max(dp[0][j-2],dp[0][j-1])+line[1][j-1];
            }

            int result = Math.max(dp[0][n],dp[1][n]);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
