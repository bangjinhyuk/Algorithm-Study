package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/08.
 */
public class BOJ_1629 {
    static long c;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        var a = Integer.parseInt(st.nextToken());
        var b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(getResult(a,b));
    }

    private static long getResult(int a, int b) {
        if(b == 0) return 1;
        long result = getResult(a,b/2)%c;
        if(b%2 ==0) return (result*result)%c;
        else{
            return ((result*result)%c*(a%c))%c;
        }

    }
}
