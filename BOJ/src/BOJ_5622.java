import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_5622 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c<'D') result+=3;
            else if(c<'G') result+=4;
            else if(c<'J') result+=5;
            else if(c<'M') result+=6;
            else if(c<'P') result+=7;
            else if(c<'T') result+=8;
            else if(c<'W') result+=9;
            else result+=10;
        }
        System.out.println(result);
    }
}
