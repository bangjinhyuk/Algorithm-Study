package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/02/22.
 */
public class BOJ_10830 {
    static int n;
    static Map<Long, int[][]> integerMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        var b = Long.parseLong(st.nextToken());
        int [][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        integerMap.put(1L,a);
        getResult(b);
        StringBuilder sb = new StringBuilder();
        int [][] result = integerMap.get(b);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(result[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void getResult(long b) {
        if(b == 1)
            return;
        int[][] tmp;
        long left = b/2;
        long right = b-b/2;
        if(!integerMap.containsKey(left))
            getResult(left);
        if(!integerMap.containsKey(right))
            getResult(right);
        tmp = cal(integerMap.get(left),integerMap.get(right));
        integerMap.put(b,tmp);
    }

    public static int[][] cal(int[][] left, int[][] right){
        int [][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    result[i][j] += left[i][k] * right[k][j];
                }
                result[i][j] %= 1000;
            }
        }
        return result;
    }

}
