package PROGRAMMERS;
import java.util.*;
/**
 * Created by bangjinhyuk on 2022/05/06.
 */
public class 합승_택시_요금 {
    public static void main(String[] args) {
        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};

        int[][] graph = new int[n+1][n+1];

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 200*100000);
            graph[i][i] = 0;
        }

        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    graph[i][j] = Math.min(graph[i][j] , graph[i][k]+graph[k][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n+1; i++) {

            answer = Math.min(answer,graph[s][i] + graph[i][a] + graph[i][b] );
        }
        System.out.println(answer);
    }
}
