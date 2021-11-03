import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/09.
 */
public class BOJ_11054 {
    static int [] numbers,reverseNumbers;
    static int [] increasedp, decreasedp, totaldp;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        numbers = new int[n+1];
        reverseNumbers = new int[n+1];
        increasedp = new int[n+1];
        decreasedp = new int[n+1];
        totaldp = new int[n+1];
        Arrays.fill(increasedp,-1);
        Arrays.fill(decreasedp,-1);
        increasedp[0] = 0;
        increasedp[1] = 1;
        decreasedp[0] = 0;
        decreasedp[1] = 1;
        numbers[0] = 1001;
        int idx = n;
        for(int i = 1;i<n+1;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            reverseNumbers[idx] =numbers[i];
            idx--;
        }

        getIncreaseDp(n);
        getDecreaseDp(n);
        for(int i = 1;i<n+1;i++){
            totaldp[i] = increasedp[i]+decreasedp[n+1-i]-1;
        }
        Arrays.sort(totaldp);
        System.out.println(totaldp[n]);
    }

    private static int getIncreaseDp(int n) {
        if(increasedp[n] ==-1){
            int result;
            boolean flag = false;
            for(int i = n-1;i>=0;i--){
                if(numbers[n]>numbers[i]){
                    result = getIncreaseDp(i)+1;
                    flag = true;
                    if(increasedp[n]<result) increasedp[n] = result;
                }else getIncreaseDp(i);
            }
            if(!flag) {
                increasedp[n] =1;
                getIncreaseDp(n-1);
            }
        }
        return increasedp[n];
    }

    private static int getDecreaseDp(int n) {
        if(decreasedp[n] ==-1){
            int result;
            boolean flag = false;
            for(int i = n-1;i>=0;i--){
                if(reverseNumbers[n]>reverseNumbers[i]){
                    result = getDecreaseDp(i)+1;
                    flag = true;
                    if(decreasedp[n]<result) decreasedp[n] = result;
                }else getDecreaseDp(i);
            }
            if(!flag) {
                decreasedp[n] =1;
                getDecreaseDp(n-1);
            }
        }
        return decreasedp[n];
    }
}
