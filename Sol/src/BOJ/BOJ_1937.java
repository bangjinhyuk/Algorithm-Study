package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/17.
 */
public class BOJ_1937 {
    static int[][] forest;
    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        dp = new int[n][n];
        for(int i =0; i < n; i++){
            var st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<n; j++){
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getdp(0,0);
        int max = 0;
        for(int i =0; i < n; i++){
            for(int j = 0; j<n; j++){
                getdp(i,j);
                if(max < dp[i][j]) max = dp[i][j];
            }
        }
        System.out.println(max);

    }

    private static int getdp(int row, int col) {
        if(dp[row][col] ==0){
            int max = 0;
            if(row>0 && forest[row][col]>forest[row-1][col]) {
                if(getdp(row-1,col)>max) max = getdp(row - 1, col);
            }
            if(col>0 && forest[row][col]>forest[row][col-1]) {
                if(getdp(row,col-1)>max) max = getdp(row, col - 1);
            }
            if(row<n-1 && forest[row][col]>forest[row+1][col]) {
                if(getdp(row+1,col)>max) {
                    max = getdp(row + 1, col);
                }
            }
            if(col<n-1 && forest[row][col]>forest[row][col+1]) {
                if(getdp(row,col+1)>max) max = getdp(row, col + 1);
            }

            return dp[row][col] = max+1;
        }
        return dp[row][col];


    }

}
