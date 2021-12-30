package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bangjinhyuk on 2021/12/30.
 */
public class BOJ_17609 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            var tmp = br.readLine();
            var left = 0;
            var right = tmp.length()-1;
            while(true){
                if(tmp.charAt(left) == tmp.charAt(right)){
                    if(right-left <2){
                        sb.append(0).append("\n");
                        break;
                    }else{
                        left++;
                        right--;
                    }
                }else{
                    if(getPalindrome(tmp,left+1,right)) sb.append(1).append("\n");
                    else if(getPalindrome(tmp,left,right-1)) sb.append(1).append("\n");
                    else sb.append(2).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean getPalindrome(String tmp, int left, int right) {
        while(true){
            if(tmp.charAt(left) == tmp.charAt(right)){
                if(right-left <2){
                    return true;
                }else{
                    left++;
                    right--;
                    continue;
                }
            }else{
                return false;
            }
        }
    }
}
