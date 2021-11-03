import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/28.
 */
public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] x = new int[n];
        int [] y = new int[n];
        StringTokenizer st;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int [] result = new int[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(i!=j && x[i]<x[j] && y[i]<y[j]){
                    result[i]++;
                }
            }
        }
        var sb = new StringBuilder();
        for(int i : result) sb.append(i+1).append(" ");
        System.out.println(sb);
    }
}
