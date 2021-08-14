import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        System.out.println((a>89) ? "A" : ((a>79) ? "B" : (a>69)? "C" : ((a>59) ? "D" : "F")));
    }
}
