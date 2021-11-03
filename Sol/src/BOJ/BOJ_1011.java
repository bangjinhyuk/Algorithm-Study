package BOJ;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_1011 {
    public static int cal(int dist){
        if (dist<3) return dist;
        else if (dist<5) return 3;
        int tmp =(int)Math.sqrt(dist);
        if (tmp == Math.sqrt(dist)) return tmp * 2 -1;
        else if (dist <= tmp * tmp+ tmp) return tmp *2;
        else return tmp * 2 +1;

    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0;i<t;i++){
            var st = new StringTokenizer(br.readLine()," ");
            int dist = Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken());
            sb.append(cal(-dist)+"\n");
        }
        System.out.println(sb);
    }
}
