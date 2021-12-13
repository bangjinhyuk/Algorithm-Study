package BOJ;

import java.io.*;
import java.util.*;


/**
 * Created by bangjinhyuk on 2021/12/07.
 */
public class BOJ_2606 {
    static boolean [] visited;
    static int [][] network;
    static int n;
    static int result= 0;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        network = new int[n+1][n+1];

        var t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            var st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a][b] = 1;
            network[b][a] = 1;
        }
        dfs(1);
        System.out.println(result);
    }

    private static void dfs(int i) {
        visited[i] = true;
        for(int j = 1; j < n+1; j++){
            if(network[i][j] == 1 && !visited[j]){
                dfs(j);
                result++;
            }
        }
    }
}
