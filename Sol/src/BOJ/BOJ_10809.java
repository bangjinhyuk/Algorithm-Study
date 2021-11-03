import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_10809 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int [] ia = new int[26];
        String str = br.readLine();
        for(int i = 0;i<str.length();i++){
            if (ia[(int)str.charAt(i)-97] ==0) ia[(int)str.charAt(i)-97] =i+1;
        }
        for(int i:ia) {
            if(i == 0) sb.append("-1 ");
            else sb.append(i-1+" ");
        }
        System.out.println(sb);
    }
}
