import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/13.
 */
public class BOJ_3036 {
    static int num;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        var sb = new StringBuilder();
        num = Integer.parseInt(st.nextToken());
        for(int i = 0;i<n-1;i++){
            int tmp = Integer.parseInt(st.nextToken());
            int max = getMin(num, tmp);
            sb.append(num/max).append("/").append(tmp/max).append("\n");
        }
        System.out.println(sb);


    }
    private static int getMin(int first, int second) {
        while(true){
            if(first>=second){
                first =first%second;
                if(first == 0){
                    return second;
                }
            }else{
                second = second%first;
                if(second == 0){
                    return first;
                }
            }
        }
    }
}

