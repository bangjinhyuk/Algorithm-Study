import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_1157 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int [] al = new int[26];
        for (int i =0;i<str.length();i++){
            al[(String.valueOf(str.charAt(i)).toLowerCase()).charAt(0)-'a']++;
        }
        String rs = "";
        int tmp=0,ri=0;
        for(int i:al){
            if(i>ri){
                ri = i;
                rs = String.valueOf((char)(tmp+'a'));
            }else if(i==ri){
                rs = "?";
            }
            tmp++;
        }
        System.out.println(rs.toUpperCase());
    }
}
