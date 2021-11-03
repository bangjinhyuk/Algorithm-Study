import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/28.
 */
public class BOJ_2231 {
    public static int cal(int n){
        int result = n;
        while(n>0){
            result += n%10;
            n /=10;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=1;i<n;i++){
            if (n == cal(i)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
