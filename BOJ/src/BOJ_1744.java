import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/10/06.
 */
public class BOJ_1744 {
    static List<Integer> positiveNum, negativeNum;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        positiveNum = new ArrayList<>();
        negativeNum = new ArrayList<>();

        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(br.readLine());
            if (temp<=0) negativeNum.add(temp);
            else positiveNum.add(temp);
        }
        Collections.sort(positiveNum);
        Collections.sort(negativeNum,Collections.reverseOrder());
        System.out.println(getMaxSum(negativeNum.size(),0)+getMaxSum(positiveNum.size(),1));

    }

    private static int getMaxSum(int size, int type) {
        int sum=0;
        for(int i = size-1; i>=0;i = i-2){
            if(i == 0) {
                if(type == 0) sum += negativeNum.get(0);
                else sum += positiveNum.get(0);
            }
            else {
                if(type == 0) sum += negativeNum.get(i) * negativeNum.get(i - 1);
                else {
                    if(positiveNum.get(i) == 1|| positiveNum.get(i-1) == 1)
                        sum += positiveNum.get(i) + positiveNum.get(i - 1);
                    else sum += positiveNum.get(i) * positiveNum.get(i - 1);
                }
            }
        }
        return sum;
    }
}
