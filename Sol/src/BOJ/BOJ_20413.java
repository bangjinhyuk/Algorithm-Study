import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/28.
 */
public class BOJ_20413 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        var grade = br.readLine();
        var s = Integer.parseInt(st.nextToken());
        var g = Integer.parseInt(st.nextToken());
        var p = Integer.parseInt(st.nextToken());
        var d = Integer.parseInt(st.nextToken());
        int result = 0;
        int before = 0;
        for(int i =0;i<n;i++){
            if(String.valueOf(grade.charAt(i)).equals("B")) {
                result += s - before - 1;
                before = s - before - 1;
            }
            else if(String.valueOf(grade.charAt(i)).equals("S")) {
                result += g - before - 1;
                before = g - before - 1;
            }
            else if(String.valueOf(grade.charAt(i)).equals("G")) {
                result += p - before - 1;
                before = p - before - 1;
            }
            else if(String.valueOf(grade.charAt(i)).equals("P")) {
                result += d - before - 1;
                before = d - before - 1;
            }
            else if(String.valueOf(grade.charAt(i)).equals("D")) {
                result += d;
                before = d;
            }
        }
        System.out.println(result);
    }
}
