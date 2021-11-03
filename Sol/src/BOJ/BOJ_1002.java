package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/20.
 */
public class BOJ_1002 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int [] x = new int[2];
        int [] y = new int[2];
        int [] r = new int[2];
        double rdist,xydist;
        for (int i = 0;i<t;i++){
            var st = new StringTokenizer(br.readLine()," ");
            for (int j = 0;j<2;j++){
                x[j] = Integer.parseInt(st.nextToken());
                y[j] = Integer.parseInt(st.nextToken());
                r[j] = Integer.parseInt(st.nextToken());
            }
            rdist = r[0]+r[1];
            xydist = Math.sqrt((x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]));

            if (xydist ==0){
                if (r[0]==r[1]) sb.append(-1).append("\n");
                else sb.append(0).append("\n");
            }else if (xydist<Math.max(r[0],r[1])) {
                if (xydist + Math.min(r[0], r[1]) < Math.max(r[0], r[1])) sb.append(0).append("\n");
                else if (xydist + Math.min(r[0], r[1]) == Math.max(r[0], r[1])) sb.append(1).append("\n");
                else sb.append(2).append("\n");
            }else {
                if (rdist>xydist) sb.append(2).append("\n");
                else if (rdist == xydist) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);


    }
}
