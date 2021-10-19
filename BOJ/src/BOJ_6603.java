import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/19.
 */
public class BOJ_6603 {
    static int [] s;
    static String tmp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        tmp = br.readLine();
        while(!tmp.equals("0")){

            var st= new StringTokenizer(tmp," ");
            int n = Integer.parseInt(st.nextToken());
            s = new int[n];
            for(int i=0;i<n;i++){
                s[i] = Integer.parseInt(st.nextToken());
            }
            getLotto(0,"");
            sb.append("\n");
            tmp = br.readLine();
        }
        System.out.println(sb);
    }

    private static void getLotto(int idx,String tmp) {
        var st = new StringTokenizer(tmp," ");
        //6개 선택되면 sb에 추가
        if(st.countTokens() == 6) {
            sb.append(tmp).append("\n");
            return;
        }
        //끝까지 갔지만 6개를 선택하지 못했을때 리턴
        if(idx == s.length) return;
        //현재 idx 수 선택
        getLotto(idx+1,tmp+s[idx]+" ");
        //현재 idx 선택이 아닌 다음수 선택
        if(tmp.length()/2+(s.length-(idx+1))>=6) getLotto(idx+1,tmp);
    }
}
