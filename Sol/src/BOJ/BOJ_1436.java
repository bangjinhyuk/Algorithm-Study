package BOJ;

import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/28.
 */
public class BOJ_1436 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tmp = 1, tmpSixNum = 0;
        while(tmpSixNum<n){
            if (String.valueOf(tmp).contains("666")){
                tmpSixNum ++;
            }
            tmp++;
        }
        System.out.println(tmp-1);
    }
}
