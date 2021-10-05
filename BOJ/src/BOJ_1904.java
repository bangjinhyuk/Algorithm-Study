import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/10/05.
 */
public class BOJ_1904 {
    static long [] data  = new long[1000000];
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        data[0] = 1;
        data[1] = 2;
        cal();
        System.out.println(data[n-1]);
    }

    private static void cal() {
        for(int i = 2;i<1000000;i++){
            data[i] = (data[i-1]+data[i-2])%15746;
        }
    }
}
