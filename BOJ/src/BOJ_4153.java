import java.io.*;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_4153 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        String tmp;
        while(true){
            tmp = br.readLine();
            if (tmp.equals("0 0 0")) break;
            var st = new StringTokenizer(tmp," ");
            int [] triangle = new int[3];
            for(int i =0;i<3; i++){
                triangle[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(triangle);
            if(triangle[0]*triangle[0]+triangle[1]*triangle[1] == triangle[2]*triangle[2]) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }
        System.out.println(sb);
    }
}
