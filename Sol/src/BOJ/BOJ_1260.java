package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/14.
 */
public class BOJ_1260 {
    static int n,m,v;
    static int [][] map;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        for(int i = 0; i < m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }
        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);

    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        visited[idx] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            sb.append(tmp).append(" ");
            for(int i = 1; i < n+1; i++){
                if(map[tmp][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }

    private static void dfs(int idx) {
        sb.append(idx).append(" ");
        visited[idx] = true;
        for(int i = 1; i < n+1; i++){
            if(map[idx][i] == 1 && !visited[i]){
                dfs(i);
                visited[i] = true;
            }
        }
    }
}
