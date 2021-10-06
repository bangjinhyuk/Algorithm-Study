import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/06.
 */
public class BOJ_2075 {
    static PriorityQueue<Integer> pqReverse = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            var st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                pqReverse.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0;i<n-1;i++) pqReverse.poll();
        System.out.println(pqReverse.peek());
    }


//    static int[][] table;
//    static int[] lastLine;
//    public static void main(String[] args) throws IOException {
//        var br = new BufferedReader(new InputStreamReader(System.in));
//        var n = Integer.parseInt(br.readLine());
//        table = new int[n][n];
//        for(int i = 0; i<n; i++){
//            var st = new StringTokenizer(br.readLine()," ");
//            for(int j=0;j<n;j++){
//                table[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        lastLine = table[n-1];
//        int max =0, secondMax=0, idx =0;
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(j == 0){
//                    max = lastLine[j];
//                    secondMax = lastLine[j];
//                }else if(lastLine[j]>max){
//                    secondMax = max;
//                    max = lastLine[j];
//                    idx = j;
//                }else if(lastLine[j]<max && lastLine[j]>secondMax){
//                    secondMax = lastLine[j];
//                }
//            }
//            lastLine[idx] =
//        }
//    }

}
