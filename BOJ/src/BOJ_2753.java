import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        System.out.println((a%4==0) ? ((a%100 == 0) ? ((a%400 == 0) ? 1 : 0) : 1) : 0);
    }
}
