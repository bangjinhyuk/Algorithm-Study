import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_10818 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = 1000000,max = -1000000;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(min>tmp) min = tmp;
            if(max<tmp) max = tmp;
        }
        System.out.println(min+" "+max);
//        int n = Integer.parseInt(br.readLine());
//        String [] ss = br.readLine().split(" ");
//        Integer [] is = new Integer[n];
//        for(int i =0; i<n; i++){
//            is[i] = Integer.parseInt(ss[i]);
//        }
//        Arrays.sort(is);
//        System.out.println(is[0]+" "+is[n-1]);
    }
}
