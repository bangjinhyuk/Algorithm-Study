package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2022/02/03.
 */
public class BOJ_3896 {
    static boolean [] decimal = new boolean[1299711];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(long i = 2; i < decimal.length; i++){
            if(!decimal[(int)i]){
                for(long j = i*i; j < decimal.length; j+=i){
                    decimal[(int)j] = true;
                }
            }
        }
        while(t-->0){
            int tmp = Integer.parseInt(br.readLine());
            if(!decimal[tmp]) {
                sb.append(0).append("\n");
            }
            else{
                int left = findLeft(tmp);
                int right = findRight(tmp);
                sb.append(right-left).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int findRight(int tmp) {
        while(true){
            tmp++;
            if(!decimal[tmp])
                return tmp;
        }
    }

    private static int findLeft(int tmp) {
        while(true){
            tmp--;
            if(!decimal[tmp])
                return tmp;
        }
    }
}