import java.io.*;


/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum=0;
        for(int i = 0; i<n ; i++){
            sum+= Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        System.out.println(sum);
    }
}
