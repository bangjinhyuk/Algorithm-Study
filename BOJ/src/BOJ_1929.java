import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/19.
 */
public class BOJ_1929 {
    public static StringBuilder cal(int m,int n) {
        var sb = new StringBuilder();
        boolean[] primeNum = new boolean[n+1];
        primeNum[1] = true;

        for(int i= 2; i <= n; i++) {
            for(int j = 2; i*j <= n; j++) {
                primeNum[i*j] = true;
            }
        }

        for(int i=m; i <= n; i++) {
            if(!primeNum[i]) sb.append(i).append("\n");
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        System.out.println(cal(m,n));
    }
}

//import java.io.*;
//import java.util.StringTokenizer;
//public class BOJ_1929 {
//    public static boolean cal(int num){
//        if(num==1|| num%2==0) return false;
//        else if (num>10&&(num%3==0||num%5==0||num%7==0)) return false;
//        for (int i =2;i*i<=num;i++){
//            if (num%i ==0) return false;
//        }
//        return true;
//    }
//    public static void main(String[] args) throws IOException {
//        var br = new BufferedReader(new InputStreamReader(System.in));
//        var sb = new StringBuilder();
//        var st = new StringTokenizer(br.readLine()," ");
//        int m = Integer.parseInt(st.nextToken());
//        int n = Integer.parseInt(st.nextToken());
//        for (int i=m; i<=n; i++){
//            if(cal(i)) {
//                sb.append(i).append("\n");
//            }
//        }
//        System.out.println(sb);
//    }
//}
