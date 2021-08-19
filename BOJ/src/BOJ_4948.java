import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_4948 {
    public static int cal(int num){
        boolean [] isprime = new boolean[2*num+1];
        isprime[1] = true;
        for (int i =2; i<=2*num ;i++){
            if(isprime[i]) continue;
            for(int j=2; j*i<=2*num; j++){
                isprime[i*j] = true;
            }
        }
        int result =0;
        for (int i =num+1; i<=2*num ;i++){
            if (!isprime[i]) {
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        while(true){
            int num = Integer.parseInt(br.readLine());
            if (num==0) {
                System.out.println(sb);
                break;
            }
            sb.append(cal(num)).append("\n");
        }
    }
}
