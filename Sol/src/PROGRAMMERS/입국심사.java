package PROGRAMMERS;

/**
 * Created by bangjinhyuk on 2022/05/05.
 */
public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        long min = 0;
        long max = 1000000000L * 1000000000L;

        long tmp = max/2;
        while(true){
            long tmpN = 0;
            for (int time : times) {
                tmpN += tmp/time;
            }
            if(tmpN >= n){
                max = tmp;
                tmp = (max+min)/2;
            }else {
                min = tmp;
                tmp = (max+min)/2;
            }
            if(min == max)
                break;
            else if(max -min == 1){
                tmpN = 0;
                for (int time : times) {
                    tmpN += min/time;
                }
                if(tmpN >= n){
                    tmp = min;
                    break;
                }else{
                    tmp = max;
                    break;
                }
            }
        }
        System.out.println(tmp);

    }
}
