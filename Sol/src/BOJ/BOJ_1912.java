package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/11.
 */
public class BOJ_1912 {
    static int [] num;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        num = new int[n];
        int max=0, tmp=0;
        var st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            if(i ==0) max = num[i];
            tmp += num[i];
            if(max<tmp) max = tmp;
            if(tmp<0) tmp = 0;

        }
        System.out.println(max);

    }

}
