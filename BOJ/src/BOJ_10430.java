import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/14.
 */
public class BOJ_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());
        int numC = Integer.parseInt(st.nextToken());

        System.out.println((numA+numB)%numC);
        System.out.println(((numA%numC) + (numB%numC))%numC);
        System.out.println((numA*numB)%numC);
        System.out.println(((numA%numC) * (numB%numC))%numC);
    }
}
