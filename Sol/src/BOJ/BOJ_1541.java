package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/12.
 */
public class BOJ_1541 {
    static int [] num;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        var st = new StringTokenizer(s, "-");
        num = new int[st.countTokens()];
        for(int i = 0;i<num.length;i++){
            var tmp = st.nextToken();
            var stTmp = new StringTokenizer(tmp,"+");
            if(stTmp.countTokens()>1){
                int tokensNum = stTmp.countTokens(),sum = 0;
                for(int j=0;j<tokensNum;j++){
                    sum +=Integer.parseInt(stTmp.nextToken());
                }
                num[i] = sum;
            }else num[i] = Integer.parseInt(tmp);
        }
        int result = 0;
        for(int i=0;i<num.length;i++){
            if(i==0) result+=num[i];
            else result = result -num[i];
        }
        System.out.println(result);
    }
}
