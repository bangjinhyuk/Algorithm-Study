import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_2839 {
    public static int cal(int n){
        if ((n%5)%3==0) return n/5 + (n%5)/3;
        int five = n/5-1;
        while(true){
            if (five<0) return -1;
            if((n-(5*five))%3==0) return five + (n-(5*five))/3;
            five--;
        }
    }
    public static void main(String[] args) throws IOException {
        var br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(cal(n));
    }
}
