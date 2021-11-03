import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/10/26.
 */
public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            String method = st.nextToken();
            if(method.equals("push")) deque.add(Integer.parseInt(st.nextToken()));
            else if(method.equals("pop")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            }
            else if(method.equals("size")) sb.append(deque.size()).append("\n");
            else if(method.equals("empty")) {
                if(deque.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }else if(method.equals("front")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.getFirst()).append("\n");
            }else if(method.equals("back")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.getLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
