import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/18.
 */
public class BOJ_2292 {
    public static int cal(int n){
        int i=1,tmp =1;
        while(true){
            if (tmp>=n) return i;
            tmp += i*6;
            i++;
        }
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(cal(Integer.parseInt(br.readLine())));
    }
}
