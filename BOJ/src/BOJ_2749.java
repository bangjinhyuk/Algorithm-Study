import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bangjinhyuk on 2021/10/22.
 */
public class BOJ_2749 {
    static int [] fibonacci;
    static int mod = 1000000;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Long.parseLong(br.readLine());
        fibonacci = new int[20000000];
        Arrays.fill(fibonacci,-1);
        fibonacci[0] =0;
        fibonacci[1] =1;
        fibonacci[2] =1;
        int i = 3;
        while(true){
            if(getFibonacci(i)==1){
                if(getFibonacci(i+1)==1) break;
            }
            i++;
        }
        System.out.println(fibonacci[(int)(n%(i-1))]);
    }

    private static int getFibonacci(int n) {
        if(fibonacci[n] ==-1){
            return fibonacci[n] = (getFibonacci(n-1)%mod+getFibonacci(n-2)%mod)%mod;
        }
        return fibonacci[n];
    }
}
