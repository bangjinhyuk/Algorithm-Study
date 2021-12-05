package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/12/05.
 */

/**
 * 고정석으로 나누어 생각할 수 있다.
 * 좌석 1개, 2개, 3개... 일때 2,3,5,8,13... 현재 좌석 까지의 가짓수는 앞의 두개의 합과 같다.
 * 하지만 뒤에 고정석이나 자리가 없다면 전의 좌석 가짓수가 현재 좌석 가짓수가 된다. 1,2,3,5,8 ...
 *
 */
public class BOJ_2302 {
    static int [] seat;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var m = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        seat = new int[n+2];
        seat[n+1] = -1;
        for(int i = 0; i < m; i++){
            seat[Integer.parseInt(br.readLine())] = -1;
        }
        int tmp = 0, sum = 1;
        for(int i = 1; i <= n+1; i++){
            if(seat[i] == 0) tmp++;
            else{
                if(tmp != 0) {
                    sum *= getdp(tmp - 1);
                    tmp = 0;
                }
            }
        }
        System.out.println(sum);
    }

    private static int getdp(int idx) {
        if(dp[idx] == 0){
            return dp[idx] = getdp(idx-2) + getdp(idx-1);
        }return dp[idx];
    }
}
