import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by bangjinhyuk on 2021/10/25.
 */
public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        String tmp = br.readLine();
        Stack<Integer> stack1, stack2;
        while(!tmp.equals(".")){
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            for(int i=0;i<tmp.length();i++){
                if(String.valueOf(tmp.charAt(i)).equals("(")) stack1.push(i);
                else if(String.valueOf(tmp.charAt(i)).equals(")")){
                    if(stack1.empty()){
                        stack1.push(1);
                        break;
                    }else {
                        if(!stack2.empty()) {
                            if (stack2.peek() < stack1.peek()) stack1.pop();
                            else {
                                stack1.push(1);
                                break;
                            }
                        }else stack1.pop();
                    }
                }
                else if(String.valueOf(tmp.charAt(i)).equals("[")) stack2.push(i);
                else if(String.valueOf(tmp.charAt(i)).equals("]")){
                    if(stack2.empty()){
                        stack2.push(1);
                        break;
                    }else {
                        if(!stack1.empty()) {
                            if (stack1.peek() < stack2.peek()) stack2.pop();
                            else {
                                stack2.push(1);
                                break;
                            }
                        }else stack2.pop();
                    }
                }
            }
            if(stack1.empty() &&stack2.empty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
            tmp = br.readLine();
        }
        System.out.println(sb);
    }
}
