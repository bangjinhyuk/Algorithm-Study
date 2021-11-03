import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        int [] is = new int[n];
        int max = 0;
        for(int i=0; i<n;i++) {
            is[i] = Integer.parseInt(st.nextToken());
            if(max<is[i]) max = is[i];
        }
        float aver = 0;
        for(int i : is) aver += (float)i / (float)max;
        System.out.println(aver*100/n);
    }
}
