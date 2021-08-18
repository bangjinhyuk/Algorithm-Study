import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/18.
 */
public class BOJ_2869 {
    public static int cal(int a, int b, int v){
        return (int) Math.ceil(((double)(v-a)/(double)(a-b))+1);
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        System.out.println(cal(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
    }
}
