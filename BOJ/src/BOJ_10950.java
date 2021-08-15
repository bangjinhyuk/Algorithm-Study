import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_10950 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        br.readLine();
        while((s = br.readLine()) != null){
            String [] tk = s.split(" ");
            System.out.println(Integer.parseInt(tk[0])+Integer.parseInt(tk[1]));
        }
    }
}
