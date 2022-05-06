package PROGRAMMERS;
import java.util.Arrays;

/**
 * Created by bangjinhyuk on 2022/05/06.
 */
public class 순위 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int[][] graph = new int[n+1][n+1];

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i],Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;

        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n+1; k++) {
                    if(graph[j][i] == graph[i][k] && (graph[j][i] ==1 || graph[j][i] == -1)) {
                        graph[j][k] = graph[j][i];
                        graph[k][j] = -graph[j][i];
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < n+1; i++) {
            boolean isPossible = true;
            for (int j = 1; j < n+1; j++) {
                if(graph[i][j] == Integer.MAX_VALUE) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible)
                answer++;
        }
        System.out.println(answer);
    }
}
