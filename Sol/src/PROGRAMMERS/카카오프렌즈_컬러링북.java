package PROGRAMMERS;

/**
 * Created by bangjinhyuk on 2022/04/19.
 */
public class 카카오프렌즈_컬러링북 {
    static boolean[][] check;
    static int[][] pictureS;
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int mS;
    static int nS;
    static int getRange;
    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int m = 6;
        int n = 4;
        pictureS = picture;
        check = new boolean[m][n];
        mS = m;
        nS = n;
        numberOfArea = 0;
        maxSizeOfOneArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!check[i][j] && picture[i][j] != 0){
                    getRange = 0;
                    getBfs(i,j,picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(getRange,maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(answer);
    }
    public static void getBfs(int x, int y, int tmp){
        getRange++;
        check[x][y] = true;
        for(int i = 0; i < 4; i++){
            x += dx[i];
            y += dy[i];
            if(x < 0 || y < 0 || x >= mS || y >= nS){
                x -= dx[i];
                y -= dy[i];
                continue;
            }
            if(!check[x][y] && pictureS[x][y] == tmp){
                getBfs(x,y,tmp);
            }
            x -= dx[i];
            y -= dy[i];
        }


    }

    public static class Location{
        int x;
        int y;
    }
}
