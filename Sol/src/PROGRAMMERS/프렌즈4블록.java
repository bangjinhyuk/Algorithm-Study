package PROGRAMMERS;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bangjinhyuk on 2022/04/17.
 */
public class 프렌즈4블록 {
    static String[][] boardS;
    static int mS;
    static int nS;
    static List<DeleteIdx> deleteIdxes;
    public static void main(String[] args) {
        int m= 6;
        int n =6;
        String[] board = {"ANTTTT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        boardS = new String[m][n];

        for(int i = 0; i < m; i++){
            for(int j  = 0; j < n; j++){
                boardS[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        mS = m;
        nS = n;
        deleteIdxes = new ArrayList<>();
        boolean isDeleted = true;
        while(isDeleted){
            isDeleted = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (!String.valueOf(boardS[i][j]).equals("0")) {
                        if (getResult(i, j)) {
                            isDeleted = true;
                        }
                    }
                }
            }
            deleteIdxes.forEach(deleteIdx -> {
                boardS[deleteIdx.x][deleteIdx.y] = "0";
            });

        }
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j  = 0; j < n; j++){
                if(boardS[i][j].equals("0"))
                    result++;
            }
        }
        System.out.println(result);


    }

    private static boolean getResult(int i, int j) {
        String now = String.valueOf(boardS[i][j]);
        int nowIdx = i;
        for(int k = i; k < mS; k++){
            if(String.valueOf(boardS[k][j]).equals("0"))
                nowIdx++;
        }

        int downIdx;
        int downTrueIdx = 0;
        boolean downBool = false;
        for (int l = 0; l < mS; l++){
            downIdx = l;
            for (int k = l+1; k < mS; k++) {
                if (String.valueOf(boardS[k][j]).equals("0"))
                    downIdx++;
            }
            downTrueIdx = l;

            if(downIdx == nowIdx+1){
                downBool = true;
                break;
            }
        }
        if(!downBool)
            return false;
        String down = String.valueOf(boardS[downTrueIdx][j]);

        int rightIdx;
        int rightTrueIdx = 0;
        boolean rightBool = false;
        for (int l = 0; l < mS; l++){
            rightIdx = l;
            for (int k = l+1; k < mS; k++) {
                if (String.valueOf(boardS[k][j+1]).equals("0"))
                    rightIdx++;
            }
            rightTrueIdx = l;
            if(rightIdx == nowIdx) {
                rightBool = true;
                break;
            }
        }
        if(!rightBool)
            return false;
        String right = String.valueOf(boardS[rightTrueIdx][j+1]);

        int rightDownIdx;
        int rightDownTrueIdx = 0;
        boolean rightDownBool = false;
        for (int l = 0; l < mS; l++){
            rightDownIdx = l;
            for (int k = l+1; k < mS; k++) {
                if (String.valueOf(boardS[k][j+1]).equals("0"))
                    rightDownIdx++;
            }
            rightDownTrueIdx = l;
            if(rightDownIdx == nowIdx+1){
                rightDownBool = true;
                break;
            }
        }
        if(!rightDownBool)
            return false;
        String rightDown = String.valueOf(boardS[rightDownTrueIdx][j+1]);

        if(now.equals(down) && right.equals(rightDown) && now.equals(right)) {
            deleteIdxes.add(new DeleteIdx(i,j));
            deleteIdxes.add(new DeleteIdx(downTrueIdx,j));
            deleteIdxes.add(new DeleteIdx(rightTrueIdx,j+1));
            deleteIdxes.add(new DeleteIdx(rightDownTrueIdx,j+1));
            return true;
        }
        return false;
    }

    public static class DeleteIdx{
        int x;
        int y;

        public DeleteIdx(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
