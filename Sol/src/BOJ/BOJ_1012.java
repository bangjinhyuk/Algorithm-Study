package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/19.
 */
public class BOJ_1012 {
    static int [][] map;
    static int result =0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int m,n;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while(t-->0){
            var st = new StringTokenizer(br.readLine()," ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            var locationNum = Integer.parseInt(st.nextToken());
            while(locationNum-->0){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 1){
                        result++;
                        dfs(i,j);
                    }
                }
            }
            sb.append(result).append("\n");
            result = 0;
        }
        System.out.println(sb);
    }

    private static void dfs(int i, int j) {
        map[i][j]=0;
        for(int k = 0; k < 4; k++){
            var newX = i + dx[k];
            var newY = j + dy[k];
            if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
            if(map[newX][newY] == 1) dfs(newX, newY);
        }
    }
}
