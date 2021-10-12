import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/12.
 */
public class BOJ_13305 {
    static long [] km, cost;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        var st1 = new StringTokenizer(br.readLine(), " ");
        km = new long[st1.countTokens()];
        var st2 = new StringTokenizer(br.readLine(), " ");
        cost = new long[st2.countTokens()];
        for(int i = 0;i<km.length;i++){
            km[i] = Integer.parseInt(st1.nextToken());
        }
        for(int i = 0;i<cost.length;i++){
            cost[i] = Integer.parseInt(st2.nextToken());
        }
        long lastCost = cost[0],sum = 0;
        for(int i = 0;i<km.length;i++){
            if(lastCost>cost[i]) lastCost = cost[i];
            sum += lastCost*km[i];
        }
        System.out.println(sum);
    }
}
