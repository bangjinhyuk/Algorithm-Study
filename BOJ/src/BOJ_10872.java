import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/22.
 */
public class BOJ_10872 {
    public static int cal(int n){
        if (n==1) return 1;
        return cal(n-1)*n;
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n ==0) System.out.println(1);
        else System.out.println(cal(n));
    }
}
