import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/22.
 */
public class BOJ_2447 {
    public static int tmp = 1;

    public static String star(int k, String pattern){
        var newPattern = new StringBuilder();
        for(int i =1; i<=3; i++){
            var st = new StringTokenizer(pattern, "\n");
            int stcount = st.countTokens();
            for (int j=0;j<stcount;j++){
                String line = st.nextToken();
                if (i ==2) newPattern.append(line+line.replaceAll("\\*"," ")+line).append("\n");
                else newPattern.append(line+line+line).append("\n");
            }
        }
        if (tmp == k) return newPattern.toString();
        tmp++;
        return star(k,newPattern.toString());
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tmp = 3;
        for(int i=1;i<8;i++){
            if (tmp == n) {
                System.out.println(star(i,"*"));
                break;
            }
            tmp *=3;
        }
    }
}
