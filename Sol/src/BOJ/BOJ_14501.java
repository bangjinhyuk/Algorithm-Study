package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/14.
 */
public class BOJ_14501 {

    static List<Counsel> counsels;
    static int max = 0;

    static class Counsel {
        int t;
        int p;

        public Counsel(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    private static void getMax(int idx, int sum) {
        if(idx == counsels.size()){
            if(max<sum) max = sum;
        }else if(idx < counsels.size()){
            getMax(idx+ counsels.get(idx).t,sum+counsels.get(idx).p);
            getMax(idx+ 1,sum);
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        counsels = new ArrayList<>();
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(br.readLine()," ");
            counsels.add(new Counsel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        getMax(0,0);
        System.out.println(max);
    }

}
