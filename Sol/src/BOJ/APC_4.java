package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/30.
 */
public class APC_4 {
    static int [] person;
    static boolean [] visit;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        person = new int[n+1];
        var st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i<=n;i++){
            person[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[n+1];
        visit[0] = true;
        getMax(1,0,"",0);

    }

    private static void getMax(int floor,int visitNum,String visits, int peopleNum) {
        if(visit[floor]){

        }else{

        }
    }
}
