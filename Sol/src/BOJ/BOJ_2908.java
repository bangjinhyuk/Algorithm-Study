import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_2908 {
    public static String reverse (String s){
        return String.valueOf(s.charAt(2))+String.valueOf(s.charAt(1))+String.valueOf(s.charAt(0));
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        String a = reverse(st.nextToken()),b =reverse(st.nextToken());
        if (Integer.parseInt(a)>Integer.parseInt(b)) System.out.println(a);
        else System.out.println(b);
    }
}
