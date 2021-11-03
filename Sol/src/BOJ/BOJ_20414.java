import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/28.
 */
public class BOJ_20414 {
    static int s,g,p,d;
    static String grade;
    static int [][] dp;
    static String tier = "BSGPD";
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        grade = br.readLine();
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        dp = new int[n+1][d+1];
        for(int i =0;i<n+1;i++) Arrays.fill(dp[i],-1);
//        System.out.println(getMax(n));
    }

    private static void getMax(int idx) {
//        if(idx==0) return 0;
//        else{
//            if(dp[idx][Arrays.stream(dp[idx-1]).max().getAsInt()] == -1){
//                return dp[idx][Arrays.stream(dp[idx-1]).max().getAsInt()];
//            }else{
//
//            }
//        }
    }

    private static int getMonthMaxbefore(int idx, int before) {
        if(String.valueOf(grade.charAt(idx)).equals("B")) {
            return s - before - 1;
        }
        else if(String.valueOf(grade.charAt(idx)).equals("S")) {
            return g - before - 1;
        }
        else if(String.valueOf(grade.charAt(idx)).equals("G")) {
            return p - before - 1;
        }
        else if(String.valueOf(grade.charAt(idx)).equals("P")) {
            return d - before - 1;
        }
        else {
            return d;
        }
    }
    private static int getMonthMaxfront(int idx, int after) {
        if(String.valueOf(grade.charAt(idx+1)).equals("B")) {
            return s - after - 1;
        }
        else if(String.valueOf(grade.charAt(idx+1)).equals("S")) {
            return g - after - 1;
        }
        else if(String.valueOf(grade.charAt(idx+1)).equals("G")) {
            return p - after - 1;
        }
        else if(String.valueOf(grade.charAt(idx+1)).equals("P")) {
            return d - after - 1;
        }
        else {
            return d;
        }
    }
}
