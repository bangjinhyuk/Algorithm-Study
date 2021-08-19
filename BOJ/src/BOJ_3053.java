import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/20.
 */
public class BOJ_3053 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        var sb =  new StringBuilder();
        sb.append(r*r*Math.PI).append("\n").append(2*r*r);
        System.out.println(sb);
    }
}
