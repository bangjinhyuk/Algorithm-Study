import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_1978 {
    public static int cal(int num){
        if(num==1) return 0;
        for (int i =2;i<num;i++){
            if (num%i ==0) return 0;
        }
        return 1;
    }



    public static void main(String[] args) throws IOException {
        var br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        int result=0;
        for (int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            result+= cal(num);
        }
        System.out.println(result);
    }
}
