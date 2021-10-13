import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/12.
 */
public class BOJ_5086 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        while(true){
            var st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if (first ==0&& second ==0) break;
            if(second>first&&second%first==0) sb.append("factor").append("\n");
            else if(first>second&&first%second ==0) sb.append("multiple").append("\n");
            else sb.append("neither").append("\n");
        }
        System.out.println(sb);
    }
}
