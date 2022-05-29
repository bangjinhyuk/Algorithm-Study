package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/05/29.
 */
public class BOJ_2920 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        int count = st.countTokens();
        int tmp = 0;
        boolean isAscending = false;
        boolean isDescending = false;


        for (int i = 0; i < count; i++) {
            if(tmp == 0){
                tmp = Integer.parseInt(st.nextToken());
            }else{
                int now = Integer.parseInt(st.nextToken());
                if(tmp < now)
                    isAscending = true;
                else
                    isDescending = true;
                tmp = now;
            }
        }

        if(isAscending && isDescending)
            System.out.println("mixed");
        else if(isAscending)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}
