import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/09.
 */

public class BOJ_2437 {
    static int [] weights;
    static int n;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        weights = new int[n];
        for (int i=0;i<n;i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weights);
        if(weights[0]!=1) System.out.println(1);
        else System.out.println(getMinImpossibleNum());

    }
    // 참조 이전까지 합+1이 현재 수보다 작으면 이전까지 합+1은 만들수 없는 수이다.
    private static int getMinImpossibleNum() {
        int result = 1;
        for(int i = 1;i<n;i++){
            if(i ==1&& weights[i]>2) return 2;
            if(i !=1 && weights[i]>result+1) return result + 1;
            result+= weights[i];
        }
        return result+1;
    }
}
