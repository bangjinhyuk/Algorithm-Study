package BOJ;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/08/28.
 */
public class BOJ_1018 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char [][] board = new char[n][m];
        for(int i = 0; i<n; i++){
            String temp = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j] = temp.charAt(j);
            }
        }
        int white = 64, black = 64;
        int whiteTmp = 0,blackTmp = 0;
        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                for(int k = i; k< i+8;k++){
                    for(int y = j; y<j+8;y++){
                        int sumIndex = y-j+k-i;
                        if(sumIndex%2 == 0 && board[k][y] == 'B'){
                            whiteTmp++;
                        }else if (sumIndex%2 == 1 && board[k][y] == 'W'){
                            whiteTmp++;
                        }
                        if(sumIndex%2 == 0 && board[k][y] == 'W'){
                            blackTmp++;
                        }else if (sumIndex%2 == 1 && board[k][y] == 'B'){
                            blackTmp++;
                        }
                    }
                }
                if (whiteTmp<white) white= whiteTmp;
                if (blackTmp<black) black= blackTmp;
                whiteTmp = 0;
                blackTmp = 0;
            }
        }
        System.out.println(Math.min(white,black));

    }
}
