package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/01/26.
 */
public class BOJ_13702 {
    static long [] makgeollis;
    static long max = 0;
    static long min = 0;
    static long k;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        makgeollis = new long[n];
        for(int i = 0; i < n; i++){
            makgeollis[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, makgeollis[i]);
        }
        System.out.println(binary((max+min)/2));
    }

    private static long binary(long middle) {
        if(max-min ==1){
            if(getResult(max) >= k) return max;
            else return min;
        }
        if(middle ==0) return 0;
        long result = getResult(middle);

        if(result < k){
            max = middle;
            return binary((max+min)/2);
        }else{
            min = middle;
            return binary((max+min)/2);
        }
    }

    private static long getResult(long middle) {
        int result = 0;
        for(long makgeolli : makgeollis){
            result += makgeolli/middle;
        }
        return result;
    }

}
