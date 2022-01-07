package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/01/06.
 */
public class BOJ_2589 {
    static String [][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int col;
    static int row;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new String[col][row];
        for(int i = 0; i < col; i++){
            String tmp = br.readLine();
            for(int j = 0; j < row; j++){
                map[i][j] = String.valueOf(tmp.charAt(j));
            }
        }
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(map[i][j].equals("L")) {
                    visited = new boolean[col][row];
                    getBfs(i, j);
                }
            }
        }
        System.out.println(result);
    }

    private static void getBfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(x,y,0));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Location tmpL = queue.poll();
            for(int i = 0; i < 4; i++) {
                int tmpX = tmpL.x + dx[i];
                int tmpY = tmpL.y + dy[i];
                if (tmpX < 0 || tmpY < 0 || tmpX >= col || tmpY >= row) continue;
                if(map[tmpX][tmpY].equals("L") && !visited[tmpX][tmpY]){
                    queue.offer(new Location(tmpX,tmpY,tmpL.result+1));
                    visited[tmpX][tmpY] = true;
                    if(result < tmpL.result+1) result = tmpL.result+1;
                }

            }
        }
    }


    private static class Location {
        int x;
        int y;
        int result;

        public Location(int x, int y, int result) {
            this.x = x;
            this.y = y;
            this.result = result;
        }
    }
}
