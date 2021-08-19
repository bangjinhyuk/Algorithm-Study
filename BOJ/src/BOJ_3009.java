import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_3009 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int x1=0,x2=0,tmp;
        int y1=0,y2=0;
        for(int i = 0;i<3 ; i++){
            var st = new StringTokenizer(br.readLine()," ");
            tmp = Integer.parseInt(st.nextToken());
            if(x1 == 0) x1 = tmp;
            else if (x1 ==tmp) x1 = 0;
            else if (x2 ==tmp) x2 = 0;
            else x2 = tmp;
            tmp = Integer.parseInt(st.nextToken());
            if(y1 == 0) y1 = tmp;
            else if (y1 ==tmp) y1 = 0;
            else if (y2 ==tmp) y2 = 0;
            else y2 = tmp;
        }
        System.out.println(Math.max(x1,x2)+" "+Math.max(y1,y2));
    }
}
