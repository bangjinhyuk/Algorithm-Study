import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_2439 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int j;
        for (int i = 1; i <=n ; i++){
            for (j = 0; j<n-i; j++) sb.append(" ");
            for (j = 0; j<i; j++) sb.append("*");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
