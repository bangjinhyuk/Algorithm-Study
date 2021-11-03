package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/30.
 */
public class APC_2 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        var t = Integer.parseInt(st.nextToken());
        var n = Integer.parseInt(st.nextToken());
        List<Player> players = new ArrayList<>();
        for(int i = 0;i<n;i++) {
        }

        for(int i = 0;i<t;i++){
            st = new StringTokenizer(br.readLine()," ");
            var logNum = Integer.parseInt(st.nextToken());
            var playerNum = Integer.parseInt(st.nextToken());
            var method = st.nextToken();
            var methodNum = Integer.parseInt(st.nextToken());





        }

    }

    static class Player{
        int location;
        String item;
    }
}
