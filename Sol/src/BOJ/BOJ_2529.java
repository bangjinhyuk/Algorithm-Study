package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/02/11.
 */
public class BOJ_2529 {
    static String [] array;
    static String min = String.valueOf(Integer.MAX_VALUE);
    static String max = "0";
    static int k ;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        array = new String[k];
        var st = new StringTokenizer(br.readLine()," ");
        int num = st.countTokens();
        for(int i = 0; i < num; i++){
            String tmp = st.nextToken();
            array[i] = tmp;
        }

        getMin("");
        getMax("");
        System.out.println(max);
        System.out.println(min);
    }

    private static void getMax(String num) {
        if(!max.equals("0"))
            return;
        if(num.length() == k+1){
            max = num;
            return;
        }

        int tmp = num.equals("")? -1 : Integer.parseInt(String.valueOf(num.charAt(num.length()-1)));

        for(int i = 9; i >= 0; i--){
            if(tmp == -1){
                getMax(num+i);
            }
            else {
                if (!num.contains(String.valueOf(i))) {
                    if (array[num.length() - 1].equals("<") && tmp < i)
                        getMax(num + i);
                    else if (array[num.length() - 1].equals(">") && tmp > i)
                        getMax(num + i);
                }
            }
        }
    }

    private static void getMin(String num) {
        if(!min.equals(String.valueOf(Integer.MAX_VALUE)))
            return;
        if(num.length() == k+1){
            min = num;
            return;
        }

        int tmp = num.equals("")? -1 : Integer.parseInt(String.valueOf(num.charAt(num.length()-1)));

        for(int i = 0; i <= 9; i++){
            if(tmp ==-1){
                getMin(num+i);
            }
            else {
                if (!num.contains(String.valueOf(i))) {
                    if (array[num.length() - 1].equals("<") && tmp < i)
                        getMin(num + i);
                    else if (array[num.length() - 1].equals(">") && tmp > i)
                        getMin(num + i);
                }
            }
        }
    }
}
