import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/18.
 */
public class BOJ_1712 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        long [] abc = new long[3];
        for(int i=0; i<3;i++) abc[i] = Integer.parseInt(st.nextToken());
        if (abc[2]<=abc[1]) System.out.println(-1);
        else System.out.println(abc[0]/(abc[2]-abc[1])+1);
    }
}
