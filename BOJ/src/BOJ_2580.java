import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/09/25.
 */
public class BOJ_2580 {
    public static int [][] Sudoku = new int[9][9];
    public static List<pos> posList;
    public static StringBuilder sb = new StringBuilder();

    public static void getSuccessSudoku(int n){
        if(n==posList.size()) {
            for(int i = 0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(Sudoku[i][j]).append(" ");
                }
                if(i<8) sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }
        for(int i =1;i<=9;i++){
            if(getValidNum(posList.get(n),i)) {
                Sudoku[posList.get(n).x][posList.get(n).y] = i;
                getSuccessSudoku(n + 1);

            }
        }
        Sudoku[posList.get(n).x][posList.get(n).y] = 0;
    }
    public static boolean getValidNum(pos p,int n){
        for(int k =0;k<9;k++){
            if(Sudoku[p.x][k]==n) return false;
            if(Sudoku[k][p.y]==n) return false;
        }
        for(int i = getstartNum(p.x); i<getstartNum(p.x)+3; i++){
            for(int j=getstartNum(p.y); j<getstartNum(p.y)+3; j++){
                if(Sudoku[i][j]==n) return false;
            }
        }
        return true;
    }


    private static int getstartNum(int i) {
        if (i<3) return 0;
        else if(i<6) return 3;
        else return 6;
    }


    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        posList = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i<9; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<9; j++){
                Sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (Sudoku[i][j] ==0) posList.add(new pos(i,j));
            }
        }
        getSuccessSudoku(0);


    }

    public static class pos{
        int x;
        int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
