package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/01/08.
 */
public class BOJ_7576 {
    static int [][] box;
    static int m,n;
    static Queue<Location> locationQueue = new LinkedList<>();
    static boolean [][] visited;
    static int [] dx = {-1, 0, 1 ,0};
    static int [] dy = {0, 1, 0 ,-1};
    static int result = 0;
    static boolean zeroFlag = false;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    box[i][j] = -2;
                    locationQueue.offer(new Location(i, j, 0));
                }
            }
        }
        getResult();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] > result) {
                    result = box[i][j];
                }
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (!zeroFlag) {
            System.out.println(0);
            return;
        }
        System.out.println(result);

    }

    private static void getResult() {
        while(!locationQueue.isEmpty()){
            Location location = locationQueue.poll();
//            visited[location.x][location.y] = true;
            for(int i = 0;i < 4; i++){
                int tmpX = location.x + dx[i];
                int tmpY = location.y + dy[i];
                if(tmpX < 0 || tmpY < 0 || tmpX >= n || tmpY >= m) continue;
                if(box[tmpX][tmpY] != -1){
                    if(box[tmpX][tmpY] == 0) {
                        box[tmpX][tmpY] = location.day + 1;
                        locationQueue.offer(new Location(tmpX, tmpY, location.day + 1));
                        if(!zeroFlag) zeroFlag = true;
                    }
                    else if(box[tmpX][tmpY] > location.day + 1 ) {
                        box[tmpX][tmpY] = location.day + 1;
                        locationQueue.offer(new Location(tmpX, tmpY, location.day + 1));
                        if(!zeroFlag) zeroFlag = true;
                    }
                }
            }
        }
    }

    private static class Location {
        int x;
        int y;
        int day;

        public Location(int x, int y,int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
