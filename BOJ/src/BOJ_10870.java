import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/22.
 */
public class BOJ_10870 {
    private static int i=2;
    public static int fibonacci(int n, int first, int second){
        if(n==i) return first +second;
        i++;
        return fibonacci(n, second, first + second);

    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n<=1) System.out.println(n);
        else System.out.println(fibonacci(n,0,1));
    }
}
