import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bangjinhyuk on 2021/09/22.
 */
public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] array = new int[n];
        int [] counting = new int[8001];
        int [] result = new int[n];
        int [] mode = new int[n];
        int mode_num = 0;
        int mode_max = 0;

        int sum = 0;

        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        for(int i : array){
            counting[i+4000] ++;
            if (counting[i+4000]>mode_max){
                mode_num = 0;
                mode[mode_num] = i;
                mode_num++;
                mode_max =  counting[i+4000];
            }
            else if(counting[i+4000]==mode_max) {
                mode[mode_num] = i;
                mode_num++;
            }
            sum += i;
        }
        for(int i = 1; i<8001; i++){
            counting[i] = counting[i-1]+counting[i];
            if (counting[i]>=n) break;
        }
        for(int i : array){
            counting[i+4000] --;
            result[counting[i+4000]] = i;
        }
        sb.append(Math.round((float)sum/(float)n)).append("\n")
                        .append(result[n/2]).append("\n");

        if(mode_num>1) {
            int [] split = Arrays.copyOfRange(mode, 0, mode_num);
            Arrays.sort(split);
            sb.append(split[1]).append("\n");
        }else sb.append(mode[0]).append("\n");
        sb.append(result[n-1] - result[0]);
        System.out.println(sb);
    }
}
