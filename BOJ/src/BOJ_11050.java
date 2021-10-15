import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/13.
 */
public class BOJ_11050 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        var n = Integer.parseInt(st.nextToken());
        var k = Integer.parseInt(st.nextToken());
        int result = 1;
        for(int i = n;i>k;i--){
            result *= i;
        }
        for(int i = n-k;i>0;i--){
            result /= i;
        }
        System.out.println(result);
    }
}
