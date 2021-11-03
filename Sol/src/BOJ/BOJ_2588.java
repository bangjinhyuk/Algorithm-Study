import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by bangjinhyuk on 2021/08/14.
 */
public class BOJ_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numA = Integer.parseInt(br.readLine());
        int numB = Integer.parseInt(br.readLine());
        System.out.println(numA*(numB%10));
        System.out.println(numA*((numB/10)%10));
        System.out.println(numA*(numB/100));
        System.out.println(numA*numB);
    }
}
