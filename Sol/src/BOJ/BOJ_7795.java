package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/20.
 */
public class BOJ_7795 {
    static int [] a,b;
    static int result;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while(t-->0){
            result =0;
            var st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            a = new int[n];
            b = new int[m];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < n;i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < m;i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for (int tmpA : a) {
                for (int tmpB : b) {
                    if (tmpA > tmpB) result++;
                    else break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
