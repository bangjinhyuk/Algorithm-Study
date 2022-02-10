package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bangjinhyuk on 2022/02/11.
 */
public class BOJ_16922 {
    static int n;
    static int [] num = {1,5,10,50};
    static Map<Integer,Boolean> makeNum ;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        makeNum = new HashMap<>();
        getResult(0, 0 ,0);
        System.out.println(makeNum.size());
    }

    private static void getResult(int idx, int sum, int pick) {
        if(idx == n){
            makeNum.put(sum,true);
            return;
        }
        for(int i = pick ; i < 4; i++){
            getResult(idx+1, num[i]+sum, i);
        }
    }
}
