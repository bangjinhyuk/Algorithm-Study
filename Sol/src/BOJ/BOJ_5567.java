package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/12/05.
 */
public class BOJ_5567 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var m = Integer.parseInt(br.readLine());
        // 나의 친구를 세면 true
        boolean [] firstVisited = new boolean[n+1];
        //나의 친구의 친구를 세면 true
        boolean [] secondvisited = new boolean[n+1];
        List<Friends> friends = new ArrayList<>();
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            friends.add(new Friends(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(friends);
        int result = 0;

        for(Friends f: friends){
            if(f.a ==1) {
                firstVisited[f.b] = true;
                result++;
            }else if(firstVisited[f.a] && !firstVisited[f.b]){
                if(!secondvisited[f.b]) {
                    result++;
                    secondvisited[f.b] = true;
                }
            }else if(firstVisited[f.b] && !firstVisited[f.a]){
                if(!secondvisited[f.a]) {
                    result++;
                    secondvisited[f.a] = true;
                }
            }
        }
        System.out.println(result);


    }
    static class Friends implements Comparable<Friends> {
        int a;
        int b;

        public Friends(int a, int b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(Friends o) {
            return this.a - o.a;
        }
    }
}
