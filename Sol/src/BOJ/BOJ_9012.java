import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by bangjinhyuk on 2021/10/25.
 */
public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        Stack<Integer> stack;
        for(int i =0;i<n;i++){
            stack = new Stack<>();
            String tmp = br.readLine();
            for(int j=0;j<tmp.length();j++){
                if(String.valueOf(tmp.charAt(j)).equals("(")) stack.push(1);
                else{
                    if(stack.empty()) {
                        stack.push(1);
                        break;
                    }else stack.pop();
                }
            }
            if(stack.empty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
