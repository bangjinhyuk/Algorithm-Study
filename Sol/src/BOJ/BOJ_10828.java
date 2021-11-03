import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/13.
 */
public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            String s = st.nextToken();
            if(s.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            if(s.equals("pop")) {
                if(stack.empty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }
            if(s.equals("size")) sb.append(stack.size()).append("\n");
            if(s.equals("empty")) {
                if(stack.empty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            if(s.equals("top")) {
                if(stack.empty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
