package BOJ;

import java.io.*;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/09/22.
 */
public class BOJ_1427 {
    static Integer [] intToArray(int n){
        Integer [] array = new Integer[10];
        int index = 0;
        while(n>=10){
            array[index] = n%10;
            n /= 10;
            index++;
        }
        array[index] = n;
        return Arrays.copyOfRange(array,0,index+1);
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        Integer [] array = intToArray(n);
        Arrays.sort(array, Collections.reverseOrder());
        for(int i : array){
            sb.append(i);
        }
        System.out.println(sb);
    }
}
