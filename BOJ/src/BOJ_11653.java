import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_11653 {
    public static StringBuilder cal(int n){
        var sb = new StringBuilder();
        int tmp = 2;
        while(n!=1){
            if(n%tmp ==0) {
                n /= tmp;
                sb.append(tmp).append("\n");
            }
            else tmp++;
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(cal(n));
    }
}
