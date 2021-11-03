import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/28.
 */
public class BOJ_20410 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        var m = Integer.parseInt(st.nextToken());
        var seed = Integer.parseInt(st.nextToken());
        var x1 = Integer.parseInt(st.nextToken());
        var x2 = Integer.parseInt(st.nextToken());
        boolean find = false;
        for(int i = 0; i<m;i++){
            for(int j = 0; j<m;j++){
                if(x1==(i*seed+j)%m&&x2==(i*x1+j)%m) {
                    System.out.println(i+" "+j);
                    find =true;
                    break;
                }
            }
            if(find) break;
        }
    }
}
