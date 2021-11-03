import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_15552 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++){
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s ," ");
            bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");
        }
        bw.flush();
    }
}
