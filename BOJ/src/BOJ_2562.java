import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_2562 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int max =0, loc = 0,tmp;
        for (int i=1;i<=9;i++){
            tmp = Integer.parseInt(br.readLine());
            if (tmp>max){
                max = tmp;
                loc = i;
            }
        }
        System.out.println(max+"\n"+loc);
    }
}
