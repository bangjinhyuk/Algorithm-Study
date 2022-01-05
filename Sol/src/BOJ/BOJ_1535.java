package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/01/01.
 */
public class BOJ_1535 {
    static int [] L;
    static int [] J;
    static int n;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        L = new int[n];
        J = new int[n];

        var st1 = new StringTokenizer(br.readLine()," ");
        var st2 = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            L[i] = Integer.parseInt(st1.nextToken());
            J[i] = Integer.parseInt(st2.nextToken());
        }
        getMax(0,100,0);
        System.out.println(max);
    }

    private static void getMax(int idx, int health, int happy) {

        if(idx>=n){
            if(max<happy) max = happy;
        }else {
            if(health - L[idx]>0)
                getMax(idx + 1, health - L[idx], happy + J[idx]);
            else{
                if(max<happy) max = happy;
            }
            getMax(idx + 1, health, happy);
        }
    }
}
