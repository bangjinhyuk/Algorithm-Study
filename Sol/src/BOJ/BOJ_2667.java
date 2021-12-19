package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by bangjinhyuk on 2021/12/19.
 */
public class BOJ_2667 {
    static int [][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] result = new int[1001];
    static int group = 1;
    static int n;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1) {
                    group++;
                    setmap(i, j);
                }
            }
        }
        var sb = new StringBuilder();
        sb.append(group-1).append("\n");
        PriorityQueue<Integer> sortResult = new PriorityQueue<>();
        for(int i = 2; i <= group; i++){
            sortResult.offer(result[i]);
        }
        while(!sortResult.isEmpty()){
            sb.append(sortResult.poll()).append("\n");
        }
        System.out.println(sb);
    }

    private static void setmap(int i, int j) {
        map[i][j] = group;
        result[group]++;
        for(int k = 0; k < 4; k++){
            int newX = i + dx[k];
            int newY = j + dy[k];
            if(newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
            if(map[newX][newY] == 1) setmap(newX, newY);
        }
    }
}
