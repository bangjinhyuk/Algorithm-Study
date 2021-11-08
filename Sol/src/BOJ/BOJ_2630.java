package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/07.
 */
public class BOJ_2630 {
    static int [][] paper;
    static int blue;
    static int white;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i =0;i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            for(int j =0;j<n;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getnum(n,0,0);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void getnum(int n,int startRow,int startCol) {
        boolean allOne = true;
        boolean allZero = true;
        for(int i =startRow;i<startRow+n;i++){
            for(int j =startCol;j<startCol+n;j++){
                if(paper[i][j] == 0 ) {
                    allOne = false;
                }
                if(paper[i][j] == 1 ) {
                    allZero = false;
                }
            }
        }
        if(allOne) {
            blue++;
        }
        else if(allZero) {
            white++;
        }
        else{
            getnum(n/2,startRow,startCol);
            getnum(n/2,startRow+n/2,startCol);
            getnum(n/2,startRow,startCol+n/2);
            getnum(n/2,startRow+n/2,startCol+n/2);
        }

    }
}
