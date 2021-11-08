package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/11/08.
 */
public class BOJ_1992 {
    static int [][] data;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        data = new int[n][n];
        for(int i = 0;i<n;i++){
            String st = br.readLine();
            for(int j = 0;j<n;j++){
                data[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
            }
        }
        System.out.println(getQuadTree(n,0,0));
    }

    private static String getQuadTree(int n,int startRow, int startCol) {
        boolean allOne =true, allZero = true;
        for(int i = startRow;i<startRow+n;i++){
            for(int j = startCol;j<startCol+n;j++){
                if(data[i][j] ==1) allZero=false;
                if(data[i][j] ==0) allOne=false;
            }
        }
        if(allZero) return "0";
        else if(allOne) return "1";
        else{
            return "("+getQuadTree(n/2,startRow,startCol)+
                    getQuadTree(n/2,startRow,startCol+n/2)+
                    getQuadTree(n/2,startRow+n/2,startCol)+
                    getQuadTree(n/2,startRow+n/2,startCol+n/2)+")";
        }

    }
}
