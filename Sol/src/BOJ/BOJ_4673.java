/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_4673 {
    public static int cal(int n){
        int sum = n;
        while(n!= 0){
            sum += n%10;
            n /=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        var sb = new StringBuilder();
        boolean [] is = new boolean[10000];
        int tmp;
        for(int i = 1 ;i<10001 ; i++){
            if ((tmp = cal(i))<10001) is[cal(i)-1]=true;
        }
        tmp = 1;
        for(boolean b: is){
            if (!b) sb.append(tmp+"\n");
            tmp++;
        }
        System.out.println(sb);
    }
}
