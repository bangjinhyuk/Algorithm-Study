import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/09/23.
 */
public class BOJ_15650 {
    public static void getSequence(int m, int [] num, int depth, String str, int lastNum){
//        System.out.println("depth: "+depth+" str: "+str+" m: "+m);
        if (depth == m){
            System.out.println(str.subSequence(0,str.length()-1));
            return;
        }
        depth ++;
        for(int i = 0;i<num.length;i++){
            if (!str.contains(num[i]+"")&& lastNum<num[i]) getSequence(m,num,depth,str+num[i]+" ",num[i]);
        }

    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = i+1;
        }
        getSequence(m,num,0,"",0);
    }
}
