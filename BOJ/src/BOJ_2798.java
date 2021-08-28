import java.io.*;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/08/28.
 */
public class BOJ_2798 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer [] cards = new Integer[n];
        st = new StringTokenizer(br.readLine()," ");
        for (int i=0;i<n;i++) cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards, Collections.reverseOrder());
        int result=0, temp;
        for(int i=0;i<n-2;i++){
            for (int j=i+1;j<n-1;j++){
                for (int k=j+1;k<n;k++){
                    temp = cards[i]+cards[j]+cards[k];
                    if(temp<=m && result<temp) {
                        result = temp;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
