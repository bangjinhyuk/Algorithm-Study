import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/09/22.
 */
public class BOJ_11651 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<coordinate> coordinates = new ArrayList<>();
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            coordinates.add(new coordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(coordinates);
        for(coordinate c: coordinates){
            sb.append(c.x).append(" ").append(c.y).append("\n");
        }
        System.out.println(sb);

    }
    public static class coordinate implements Comparable<coordinate>{
        private int x;
        private int y;

        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(coordinate o) {
            if(this.y > o.y)
                return 1;
            else if (this.y == o.y){
                if(this.x > o.x){
                    return 1;
                }else return -1;
            }else return -1;
        }
    }
}
