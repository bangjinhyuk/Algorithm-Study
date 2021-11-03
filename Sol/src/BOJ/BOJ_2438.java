import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_2438 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++){
            for (int j=0; j<i; j++) bw.write("*");
            bw.write("\n");
        }
        bw.flush();
    }
}
