package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/09.
 */
public class BOJ_13023 {
    static ArrayList<Integer>[] list;
    static int n;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i=0; i<n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        for(int i = 0; i < n;i++){
            visited = new boolean[n];
            if(dfs(i,1)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean dfs(int idx,int visitNum) {
        if(visitNum == 5) return true;
        visited[idx] = true;
        for(int i: list[idx]){
            if(!visited[i]){
                if(dfs(i,visitNum+1)) return true;
            }
        }
        visited[idx] = false;
        return false;
    }
}
