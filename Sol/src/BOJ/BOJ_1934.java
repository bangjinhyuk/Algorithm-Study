import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/12.
 */
public class BOJ_1934 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        for(int i=0;i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int num = getMin(first,second);
            sb.append((first/num)*second).append("\n");
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
