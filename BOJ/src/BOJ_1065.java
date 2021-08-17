import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_1065 {
    public static boolean cal(int num){
        if (num<100) return true;
        int tmp = num%10 - (num/10)%10;
        num /= 10;
        while (num>9){
            if (tmp != num%10-(num/10)%10) return false;
            num /= 10;
        }
        return true;

    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result=0;
        for(int i =1; i<=n ; i++){
            if(cal(i)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
