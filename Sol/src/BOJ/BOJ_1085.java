package BOJ;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_1085 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        int [] coord = new int[4];
        for(int i=0;i<4; i++) coord[i] = Integer.parseInt(st.nextToken());
        int result = 1000,tmp;
        for (int i = 0; i<2; i++){
            if (result>(tmp=Math.min(coord[i],coord[i+2]-coord[i]))) result = tmp;
        }
        System.out.println(result);
    }
}
