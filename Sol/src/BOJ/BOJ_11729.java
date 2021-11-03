import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/23.
 */
public class BOJ_11729 {

    public static StringBuilder sb = new StringBuilder();
    public static int result = 0;
    public static void hanoi(int n,int start, int center,int finish){
        if (n==1) {
            result ++;
            sb.append(start + " " + finish).append("\n");
            return;
        }
        hanoi(n-1,start, finish, center);
        result++;
        sb.append(start + " "+ finish).append("\n");
        hanoi(n-1,center, start, finish);
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        hanoi(k,1,2,3);
        System.out.println(result+"\n" +sb.toString());
    }
}
