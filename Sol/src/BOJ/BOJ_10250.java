import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/18.
 */
public class BOJ_10250 {
    public static String cal(int h,int w, int n){
        int tmp = (int)Math.ceil((float)n/(float)h);
        return n-h*(tmp-1)+String.format("%02d",tmp);
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        for (int i=0;i<t;i++) {
            var st = new StringTokenizer(br.readLine(), " ");
            sb.append(cal(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()))+"\n");
        }
        System.out.println(sb);
    }
}
