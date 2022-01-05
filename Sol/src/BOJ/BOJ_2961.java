package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/01/01.
 */
public class BOJ_2961 {
    static int [] S;
    static int [] B;
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        S = new int[n];
        B = new int[n];


        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(br.readLine()," ");
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        getMin(0,1,0);
        System.out.println(min);
    }

    private static void getMin(int idx, int sResult, int bResult) {
        if(idx>=n){
            if(min>Math.abs(sResult-bResult)&&(sResult!=1&&bResult!=0)) min = Math.abs(sResult-bResult);
        }else {
            getMin(idx + 1, sResult * S[idx], bResult + B[idx]);
            getMin(idx + 1, sResult, bResult);
        }
    }
}
