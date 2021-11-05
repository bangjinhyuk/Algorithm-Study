package PROGRAMMERS;

/**
 * Created by bangjinhyuk on 2021/11/05.
 */
public class 네트워크 {
    class Solution {
        static boolean [] visited;
        static int[][] sComputers;
        public int solution(int n, int[][] computers) {
            int answer = 0;

            visited = new boolean [n];
            sComputers = computers;

            for(int i = 0;i<n;i++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(i);
                    answer ++;
                }
            }


            return answer;
        }
        static void dfs(int idx){
            for(int i = 0;i<visited.length;i++){
                if(idx != i && sComputers[idx][i] ==1 && !visited[i]){
                    visited[i] = true;
                    dfs(i);
                }
            }
        }


    }
}
