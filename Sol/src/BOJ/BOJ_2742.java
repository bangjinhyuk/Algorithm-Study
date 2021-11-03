import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_2742 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = n; i>0; i--) bw.write(i+"\n");
        bw.flush();
    }
}