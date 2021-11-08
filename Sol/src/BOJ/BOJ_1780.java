package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/08.
 */
public class BOJ_1780 {
    static int[][] paper;
    static int minusOne, zero, one;
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
        getPaperNum(n,0,0);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }
    private static void getPaperNum(int n,int startRow,int startCol) {
        boolean allOne = true;
        boolean allMinusOne = true;
        boolean allZero = true;
        for(int i =startRow;i<startRow+n;i++){
            for(int j =startCol;j<startCol+n;j++){
                if(paper[i][j] == 0 ) {
                    allOne = false;
                    allMinusOne = false;
                }
                if(paper[i][j] == 1 ) {
                    allZero = false;
                    allMinusOne = false;
                }
                if(paper[i][j] == -1 ) {
                    allZero = false;
                    allOne = false;
                }
            }
        }
        if(allOne) {
            one++;
        }
        else if(allZero) {
            zero++;
        }
        else if(allMinusOne) {
            minusOne++;
        }
        else{
            getPaperNum(n/3,startRow,startCol);
            getPaperNum(n/3,startRow+n/3,startCol);
            getPaperNum(n/3,startRow+n/3,startCol+n/3);
            getPaperNum(n/3,startRow+n/3,startCol+n/3*2);
            getPaperNum(n/3,startRow+n/3*2,startCol);
            getPaperNum(n/3,startRow+n/3*2,startCol+n/3);
            getPaperNum(n/3,startRow+n/3*2,startCol+n/3*2);
            getPaperNum(n/3,startRow,startCol+n/3);
            getPaperNum(n/3,startRow,startCol+n/3*2);
        }

    }
}
