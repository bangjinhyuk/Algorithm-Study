package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/06.
 */
public class BOJ_2210 {
    static int [][] digits;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<String> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        digits = new int[5][5];
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++){
                digits[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                getNum(i,j,String.valueOf(digits[i][j]));
            }
        }
        System.out.println(results.stream().distinct().count());

    }

    private static void getNum(int i, int j, String tmp) {
        if(tmp.length() == 6) {
            results.add(tmp);
        }
        else {
            for (int k = 0; k < 4; k++) {
                int tmpx, tmpy;
                tmpx = i + dx[k];
                tmpy = j + dy[k];
                if (tmpx < 0 || tmpy < 0 || tmpx > 4 || tmpy > 4) continue;
                getNum(tmpx, tmpy, tmp + digits[tmpx][tmpy]);
            }
        }
    }
}
