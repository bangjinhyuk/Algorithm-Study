import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_2581 {
    public static boolean cal(int num){
        if(num==1) return false;
        for (int i =2;i<num;i++){
            if (num%i ==0) return false;
        }
        return true;

    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int min=0,sum=0;
        for (int i=m; i<=n; i++){
            if(cal(i)) {
                if (min==0) min=i;
                sum+=i;
            }

        }
        if(min == 0) System.out.println(-1);
        else {
            sb.append(sum).append("\n").append(min);
            System.out.println(sb);
        }
    }
}
