import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/27.
 */
public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> deque = new LinkedList<>();
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            String method = st.nextToken();
            if(method.equals("push_front")) deque.addFirst(Integer.parseInt(st.nextToken()));
            else if(method.equals("push_back")) deque.addLast(Integer.parseInt(st.nextToken()));
            else if(method.equals("pop_front")){
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            }
            else if(method.equals("pop_back")){
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollLast()).append("\n");
            }
            else if(method.equals("size")) sb.append(deque.size()).append("\n");
            else if(method.equals("empty")) {
                if(deque.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if(method.equals("front")){
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            }
            else if(method.equals("back")){
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
