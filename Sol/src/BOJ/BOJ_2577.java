import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        Integer [] is = new Integer[3];
        for(int i=0;i<3;i++) is[i] = Integer.parseInt(br.readLine());
        String str = Integer.toString(is[0]*is[1]*is[2]);
        int [] is2 = new int[10];
        for(int i=0;i<str.length();i++) {
            is2[Integer.parseInt(String.valueOf(str.charAt(i)))]++;
        }
        for(int i: is2){
            sb.append(i+"\n");
        }
        System.out.println(sb);
    }
}
