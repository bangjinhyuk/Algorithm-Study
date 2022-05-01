package PROGRAMMERS;
import java.util.*;
/**
 * Created by bangjinhyuk on 2022/05/01.
 */
public class 비밀지도 {
    static int nS;
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = new String[n];
        nS = n;
        answer[1].substring(12);
        for(int i = 0; i < n; i++){
            String tmp1 = getWidth(arr1[i]);
            String tmp2 = getWidth(arr2[i]);
            answer[i] = "";
            for(int j = 0; j < n; j++){
                if(String.valueOf(tmp1.charAt(j)).equals("0") && String.valueOf(tmp2.charAt(j)).equals("0"))
                    answer[i] += " ";
                else
                    answer[i] += "#";
            }
        }
        for (String s : answer) {
            System.out.println(s);
        }
    }
    public static String getWidth(int num){
        String result = "";
        int q = num;
        int r;
        while(true){
            r = q%2;
            q /= 2;
            result = r + result;
            if(q == 0)
                break;
        }
        while(result.length() < nS){
            result = 0 + result;
        }
        return result;
    }
}
