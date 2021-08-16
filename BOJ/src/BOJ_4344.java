import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_4344 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());
        int n,p =0;
        float average=0;
        for(int i = 0; i<c;i++){
            var st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            int [] is = new int[n];
            for (int j=0; j<n; j++){
                is[j] = Integer.parseInt(st.nextToken());
                average += (float)is[j];
            }
            average /= n;
            for(int k :is){
                if (k>average) p++;
            }
            sb.append(String.format("%.03f", Math.round((float)p/(float)n*100000)/1000.0)+"%\n");
            average = 0;
            p = 0;
        }
        System.out.println(sb);
    }
}
