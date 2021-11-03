import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/09/23.
 */
public class BOJ_15651 {
    public static StringBuilder getSequence(int m, int [] num, int depth, String str){
//        System.out.println("depth: "+depth+" str: "+str+" m: "+m);
        var sb = new StringBuilder();
        if (depth == m){
            return sb.append(str.subSequence(0,str.length()-1));
        }
        depth ++;
        for(int i = 0;i<num.length;i++){
            if(i == num.length-1) sb.append(getSequence(m,num,depth,str+num[i]+" "));
            else sb.append(getSequence(m,num,depth,str+num[i]+" ")+"\n");
        }
        return sb;
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
        System.out.println(getSequence(m,num,0,""));
    }
}
