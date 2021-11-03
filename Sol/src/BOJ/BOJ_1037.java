package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/12.
 */
public class BOJ_1037 {
    static int [] divisor;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        divisor = new int[st.countTokens()];
        for(int i = 0;i<n;i++){
            divisor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(divisor);
        System.out.println(divisor[0]*divisor[n-1]);
    }
}
