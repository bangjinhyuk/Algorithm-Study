import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/11.
 */
public class BOJ_11047 {
    static int [] coins;
    static int n;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        var k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        for(int i =0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(getMinCoin(k));
    }

    private static int getMinCoin(int k) {
        int result=0;
        for(int i = n-1; i>=0; i--){
            if(coins[i]<=k){
                result += k/coins[i];
                k = k%coins[i];
            }
            if (k == 0) break;
        }
        return result;
    }

}
