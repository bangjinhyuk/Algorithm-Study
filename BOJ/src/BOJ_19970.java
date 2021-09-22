import java.io.*;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/09/22.
 */
public class BOJ_19970 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        var st = new StringTokenizer(br.readLine()," ");
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        int [] earlyArray = Arrays.copyOf(array,array.length);
        Arrays.sort(array);
        int [] sortarray = new int[n];
        int prevNum = 1000000001;
        int index=0;
        for (int i : array){
            if(prevNum != i) {
                prevNum = i;
                sortarray[index] = i;
                index ++;
            }
        }
        sortarray = Arrays.copyOfRange(sortarray,0,index);
        for (int i : earlyArray) {
            sb.append(Arrays.binarySearch(sortarray,i)).append(" ");
        }
        System.out.println(sb);

    }
}
