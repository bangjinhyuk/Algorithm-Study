import java.io.*;
import java.util.StringTokenizer;


/**
 * Created by bangjinhyuk on 2021/08/15.
 */
public class BOJ_11022 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String s;
        int a,b;
        for(int i = 1; i<=t ; i++){
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write("Case #"+i+": "+a+" + "+b+" = "+(a+b)+"\n");
        }
        bw.flush();
    }
}