import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_9020 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine()), n;
        for (int i=0;i<t;i++){
            n = Integer.parseInt(br.readLine());
            sb.append(cal(n,getprimes(n))).append("\n");

        }
        System.out.println(sb);
    }
    public static boolean [] getprimes(int n){
        boolean [] primes = new boolean[n];
        primes[0]=primes[1]=true;
        for (int i =2; i<n;i++){
            for (int j=2;j*i<n;j++){
                primes[j*i] = true;
            }
        }
        return primes;
    }

    public static String cal(int n,boolean [] primes){
        int tmp = 0,save = 0;
        for (boolean i : primes){
            if (tmp>n/2) break;
            if (!i){
                if (!primes[n-tmp]&&save<n) save = tmp;
            }
            tmp++;
        }
        return save+" "+(n-save);
    }
}
