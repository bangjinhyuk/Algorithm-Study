import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/09/22.
 */
public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] array = new int[n];
        int [] counting = new int[10001];
        int [] result = new int[n];
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        for(int i : array){
            counting[i] ++;
        }
        for(int i =1; i<10001; i++){
            counting[i] = counting[i-1]+counting[i];
            if (counting[i]>=n) break;
        }
        for(int i : array){
            counting[i] --;
            result[counting[i]] = i;
        }
        for(int i : result){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
