import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_10757 {
    public static StringBuilder plus(String a ,String b){
        var sb = new StringBuilder();
        int alen=a.length()-1, blen=b.length()-1;
        int tmp,longlen = a.length();
        boolean upten = false;

        if (alen < blen) longlen = b.length();
        for(int i =0; i<longlen;i++){
            if (alen <0) tmp = Integer.parseInt(String.valueOf(b.charAt(blen)));
            else if (blen < 0 ) tmp = Integer.parseInt(String.valueOf(a.charAt(alen)));
            else tmp = Integer.parseInt(String.valueOf(b.charAt(blen)))
                        +Integer.parseInt(String.valueOf(a.charAt(alen)));
            if (upten) {
                tmp++;
                upten = false;
            }
            if (tmp<10) sb.append(tmp);
            else {
                sb.append(tmp % 10);
                upten = true;
            }
            alen --;
            blen --;
        }
        if (upten) sb.append(1);
        return sb.reverse();

    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        System.out.println(plus(st.nextToken(),st.nextToken()));
    }
}
