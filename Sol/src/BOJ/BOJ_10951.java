import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_10951 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var sb = new StringBuilder();
        String s;
        int a,b;
        while((s=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(s," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append((a+b)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
