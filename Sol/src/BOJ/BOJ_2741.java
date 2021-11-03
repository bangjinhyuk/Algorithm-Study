import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_2741 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) bw.write(i+"\n");
        bw.flush();
    }
}
