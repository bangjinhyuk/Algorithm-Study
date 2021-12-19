package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/19.
 */
public class BOJ_2178 {
    static int [][] map;
    static int result;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int m,n;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = n*m;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            var tmp = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(x,y));
        visited[x][y] = true;
        while(!points.isEmpty()){
            Point point = points.poll();
            for(int k = 0; k < 4; k++){
                var newX = point.x + dx[k];
                var newY = point.y + dy[k];
                if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                if(map[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    map[newX][newY] = map[point.x][point.y]+1;
                    points.offer(new Point(newX,newY));
                }
            }
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
