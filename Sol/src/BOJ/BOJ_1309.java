package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/12/02.
 */

/**
 * 윗칸부터 사자를 왼쪽에 넣거나 오른쪽에 넣거나 안넣는 경우로 재귀
 * 마지막칸에 도달시 경우 +1
 * 윗칸에 배치한 결과를 가지고 있어야함(왼쪽,오른쪽으로 저장)
 * => 시간초과
 * 첫칸 3가지 경우
 * 두번째칸 경우 첫번째 칸 왼쪽 배치시 2가지 경우, 오른쪽 배치시 2가지 경우, 배치 안했을때 3가지 경우로 2+2+3= 7
 * 세번째칸까지 고려하면 3가지 경우는 =>2+2+3의 경우로 다음칸에 늘어나며 2가지 경우는 =>2+3 경우로 늘어남
 *                              3                               3 개수 1, 2개수 0 ==> 3가지 경우
 *                 2            2              3                3 개수 1, 2개수 2 ==> 7가지 경우
 *              2     3     2      3     2     2     3          3 개수 3, 2개수 4 ==> 17가지 경우
 *             2 3  2 2 3  2 3   2 2 3  2 3   2 3  2 2 3        3 개수 7, 2개수 10 ==> 41가지 경우
 *
 */
public class BOJ_1309 {
    static int n;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int two = 0, three = 1;
        int MOD = 9901;

        for(int i = 2; i <= n; i++){
            int tmp = two;
            two += three*2;
            three += tmp;
            two %=MOD;
            three %=MOD;
        }
        System.out.println((three*3+two*2)%MOD);

    }

}
