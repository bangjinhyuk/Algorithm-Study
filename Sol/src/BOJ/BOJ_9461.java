import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/10/05.
 */

public class BOJ_9461 {
    static long [] data = new long[100];
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var t = Integer.parseInt(br.readLine());
        data[0] = 1;
        data[1] = 1;
        data[2] = 1;
        data[3] = 2;
        cal();
        for(int i = 0; i<t; i++){
            sb.append(data[Integer.parseInt(br.readLine())-1]).append("\n");
        }
        System.out.println(sb);
    }

    private static void cal() {
        for(int i=4;i<100;i++){
            data[i] = data[i-2]+data[i-3];
        }
    }
}
