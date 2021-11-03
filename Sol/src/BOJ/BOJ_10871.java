import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_10871 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int tmp;
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<n; i++){
            tmp = Integer.parseInt(st1.nextToken());
            if(tmp < x) sb.append(tmp+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
