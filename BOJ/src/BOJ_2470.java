import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/13.
 */
public class BOJ_2470 {
    static int [] num;
    static int n;
    static MinNumSet minNumSet=null;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        var st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        //초기 값 설정 및 합이 0또는 0보다 크거나 작은지 확인후 front, back 조절
        minNumSet = new MinNumSet(Math.abs(num[0]+num[n-1]),num[0],num[n-1]);
        if(minNumSet.min==0 ||n ==2) minNumSet = new MinNumSet(0,num[0],num[n-1]);
        else if(num[0]+num[n-1]>0) minNumSet = getMinNums(0,n-2);
        else minNumSet = getMinNums(1,n-1);

        sb.append(minNumSet.first).append(" ").append(minNumSet.second);
        System.out.println(sb);

    }

    private static MinNumSet getMinNums(int front,int back) {
        int tmp = Math.abs(num[front]+num[back]);
        //0일때 바로 리턴
        if(tmp==0) return new MinNumSet(0,num[front],num[back]);
        // 합이 0보다 크면 back-1
        else if(num[front]+num[back]>0) {
            if(tmp<minNumSet.min) minNumSet = new MinNumSet(tmp,num[front],num[back]);
            if(front == back-1) return minNumSet;
            return getMinNums(front, back - 1);
        }
        //합이 0보다 작으면 front+1
        else {
            if(tmp<minNumSet.min) minNumSet = new MinNumSet(tmp,num[front],num[back]);
            if(front == back-1) return minNumSet;
            return getMinNums(front + 1, back);
        }
    }

    static class MinNumSet{
        int min;
        int first;
        int second;

        public MinNumSet(int min, int first, int second) {
            this.min = min;
            this.first = first;
            this.second = second;
        }
    }
}
