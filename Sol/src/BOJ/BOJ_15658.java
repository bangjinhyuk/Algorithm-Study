package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/02/11.
 */
public class BOJ_15658 {
    static int [] nums;
    static int [] operator = {0,0,0,0};
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        var st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        getResult("");
        System.out.println(max);
        System.out.println(min);
    }

    private static void getResult(String select) {
        if(select.length() == n-1){
            int result = nums[0];
            for(int i = 0; i < n-1; i++){
                if(String.valueOf(select.charAt(i)).equals("0"))
                    result += nums[i+1];
                else if(String.valueOf(select.charAt(i)).equals("1"))
                    result -= nums[i+1];
                else if(String.valueOf(select.charAt(i)).equals("2"))
                    result *= nums[i+1];
                else
                    result /= nums[i+1];
            }
            max = Math.max(max,result);
            min = Math.min(min,result);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                operator[i] -= 1;
                getResult(select+i);
                operator[i] += 1;
            }
        }
    }
}
