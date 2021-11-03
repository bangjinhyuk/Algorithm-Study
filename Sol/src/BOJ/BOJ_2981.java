import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/10/13.
 */
public class BOJ_2981 {
    static int [] num;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var n =  Integer.parseInt(br.readLine());
        num = new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            num[i] =Integer.parseInt(br.readLine());
            if(i ==0) max = num[i];
            else max = Math.max(max,num[i]);
        }
        for(int i=2;i<=max;i++){
            int remainder = 0;
            for(int j=0;j<num.length;j++){
                if(j == 0) {
                    remainder = num[j] % i;
                }
                else{
                    if(remainder!=num[j]%i) break;
                    else if(j == num.length-1) sb.append(i).append(" ");

                }
            }
        }
        System.out.println(sb);

    }
}
