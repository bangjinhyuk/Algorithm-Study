import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/18.
 */
public class BOJ_2775 {
    public static int[][] get() {
        int [][] set = new int[15][15];
        for(int i = 0;i<15;i++){
            set[i][1]=1;
            set[0][i]=i;
        }
        for(int i = 1;i<15;i++){
            for(int j = 2;j<15;j++){
                set[i][j] = set[i][j-1]+set[i-1][j];
            }
        }
        return set;
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int [][] apt = get();

        for(int i=0; i<t;i++){
            sb.append(apt[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())]+"\n");
        }
        System.out.println(sb);
    }
}
