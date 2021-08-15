import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_8393 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        int a = Integer.parseInt(br.readLine());
        for (int i = 1 ;i <= a; i++) num += i;
        System.out.println(num);
    }
}
