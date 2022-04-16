package PROGRAMMERS;

/**
 * Created by bangjinhyuk on 2022/04/16.
 */
public class 거리두기_확인하기 {

    static int dx[] = {0,1,0,-1};
    static int dy[] = {-1,0,1,0};
    static boolean[][] check;

    public static void main(String[] args) {
        String[][] places ={{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}};

        int[] answer = new int[places.length];

        for(int i = 0; i < places.length; i++){
            answer[i] = result(places[i]);
        }

        System.out.println(answer);
    }
    public static int result(String[] place){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(String.valueOf(place[i].charAt(j)).equals("P")){
                    check = new boolean[5][5];
                    if(getResult(place,i,j,0) == 0)
                        return 0;
                }
            }
        }
        return 1;
    }
    public static int getResult(String[] place, int x, int y, int tmp){
        check[x][y] = true;
        for(int i = 0; i < 4; i++){

            x += dx[i];
            y += dy[i];
            if(x < 0 || y < 0 || x > 4 || y > 4){
                x -= dx[i];
                y -= dy[i];
                continue;
            }
            if(!check[x][y] && String.valueOf(place[x].charAt(y)).equals("P")){
                return 0;
            }
            else if(String.valueOf(place[x].charAt(y)).equals("O") && tmp < 1){
                if(getResult(place, x, y, tmp+1) == 0)
                    return 0;
            }
            x -= dx[i];
            y -= dy[i];
        }
        check[x][y] = false;
        return 1;
    }
}
