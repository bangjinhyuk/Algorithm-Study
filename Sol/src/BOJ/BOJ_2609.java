import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/12.
 */
public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int max = 1,min=0;
        for(int i = 2;i<Math.min(first,second)+1;i++){
            if(first%i ==0 && second%i==0) max  =i;
        }
        for(int i = Math.max(first,second);i<first*second+1;i++){
            if(i%first==0 && i%second==0) {
                min = i;
                break;
            }
        }
        System.out.println(max+"\n"+min);
    }
}
