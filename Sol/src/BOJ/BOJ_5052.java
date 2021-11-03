import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bangjinhyuk on 2021/10/09.
 */
public class BOJ_5052 {
    static String [] callNum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            var n = Integer.parseInt(br.readLine());
            callNum = new String[n];
            for(int j=0;j<n;j++){
                callNum[j] = br.readLine();
            }
            Arrays.sort(callNum);
            checkNum();
        }
        System.out.println(sb);
    }

    private static void checkNum() {
        for(int i=0;i<callNum.length-1;i++){
            if(callNum[i+1].length()>=callNum[i].length())
            if(callNum[i+1].substring(0,callNum[i].length()).equals(callNum[i])){
                sb.append("NO").append("\n");
                return;
            }
        }
        sb.append("YES").append("\n");
    }
}
