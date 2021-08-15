import java.io.*;


/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_1110 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n<10) n*=10;
        int t = n, cy =0;
        while(true){
            t = Integer.parseInt(Integer.toString(t % 10) + Integer.toString((t / 10 + t % 10) % 10));
            cy++;
            if (t == n) break;
        }
        System.out.println(cy);
    }
}
