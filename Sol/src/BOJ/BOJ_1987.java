package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/02/11.
 */
public class BOJ_1987 {
    static String [][] board;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {-1, 0, 1, 0};
    static int max = 0;
    static int R, C;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new String[R][C];
        for(int i = 0; i < R; i++){
            String tmp = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = String.valueOf(tmp.charAt(j));
            }
        }
        String tmp = board[0][0];
        board[0][0] = "1";
        getResult(tmp,0,0);
        System.out.println(max);
    }

    private static void getResult(String tmpS, int x, int y) {
        boolean next = false;
        for(int i = 0; i < 4; i++){
            x += dx[i];
            y += dy[i];
            if(x < 0 || y < 0 || x >= R || y >= C) {
                x -= dx[i];
                y -= dy[i];
                continue;
            }
            if(!board[x][y].equals("1") && !tmpS.contains(board[x][y])) {
                String tmp = board[x][y];
                board[x][y] = "1";
                getResult(tmpS + tmp, x, y);
                board[x][y] = tmp;
                next = true;
            }
            x -= dx[i];
            y -= dy[i];
        }
        if(!next)
            max = Math.max(max, tmpS.length());
    }
}
