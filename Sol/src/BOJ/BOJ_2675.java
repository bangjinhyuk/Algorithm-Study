import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_2675 {
    public static String cal(int r,String s){
        String result="";
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<r; j++) result += String.valueOf(s.charAt(i));
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            var st = new StringTokenizer(br.readLine()," ");
            sb.append(cal(Integer.parseInt(st.nextToken()),st.nextToken())+"\n");
        }
        System.out.println(sb);
    }
}
