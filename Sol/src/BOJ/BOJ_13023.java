package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/12/09.
 */
public class BOJ_13023 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        var n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        List<Friends> friendsList = new ArrayList<>();
        while(m-->0){
            st = new StringTokenizer(br.readLine()," ");
            friendsList.add(new Friends(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(friendsList);



    }
    static class Friends implements Comparable<Friends>{
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
