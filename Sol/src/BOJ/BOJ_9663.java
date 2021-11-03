import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by bangjinhyuk on 2021/09/23.
 */
public class BOJ_9663 {
    static int num =0;
    static int [] chessBoard;

    public static void cal(int[] chessBoard,int n,int m){
        if(m==n) {
            num++;
            return;
        }
        for(int i=0;i<n;i++){
            boolean diagonal = true;
            boolean contain = true;
            for(int j =0 ;j<m;j++){
                if(Math.abs(j-m)==Math.abs(chessBoard[j]-i)) diagonal = false;
                if(chessBoard[j] == i) contain = false;
            }
            if(contain && diagonal){
                chessBoard[m] = i;
                cal(chessBoard,n,m+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        chessBoard = new int[n];
        Arrays.fill(chessBoard,-1);
        cal(chessBoard,n,0);
        System.out.println(num);
    }
}
