package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
/**
 * Created by bangjinhyuk on 2022/03/29.
 */
public class BOJ_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger result = new BigInteger("1");
        for (int i = 0; i < m; i++) {
            result = result.multiply(new BigInteger(n+""));
            n--;
        }
        while(m-->0){
            result = result.divide(new BigInteger((m+1)+""));
        }
        System.out.println(result);
    }
}