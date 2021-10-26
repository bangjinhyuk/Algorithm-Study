import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/26.
 */
public class BOJ_11866 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        var n = Integer.parseInt(st.nextToken());
        var k = Integer.parseInt(st.nextToken());
        var sb = new StringBuilder();
        sb.append("<");
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            deque.add(i);
        }
        while(deque.size()>1){
            for(int i = 1;i<k;i++){
                deque.addLast(deque.pollFirst());
            }
            sb.append(deque.pollFirst()).append(", ");
        }
        sb.append(deque.peek()).append(">");
        System.out.println(sb);

    }
}
