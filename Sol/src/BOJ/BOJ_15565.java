package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/24.
 */
public class BOJ_15565 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        var n = Integer.parseInt(st.nextToken());
        var k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        List<Integer> lions = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(Integer.parseInt(st.nextToken()) == 1) lions.add(i);
        }
        if(lions.size()<k) {
            System.out.println(-1);
            return;
        }
        var result = Integer.MAX_VALUE;
        for(int i = 0; i < lions.size()-k+1; i++){
            System.out.println(i+" / "+(lions.get(i+k-1)-lions.get(i)+1));
            if(result > lions.get(i+k-1)-lions.get(i)+1) {
                result = lions.get(i + k - 1) - lions.get(i) + 1;
            }
        }
        System.out.println(result);

    }
}
