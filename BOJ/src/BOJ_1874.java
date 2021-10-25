import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;

/**
 * Created by bangjinhyuk on 2021/10/25.
 */
public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        int [] num = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        int tmpIdx = 0,tmpNum = 1;
        while(tmpNum<n+2){
            if(stack.empty()) {
                if(tmpNum<=n){
                    sb.append("+").append("\n");
                    stack.push(tmpNum);
                }
                tmpNum++;
            }
            else{
                if(stack.peek() == num[tmpIdx]){
                    sb.append("-").append("\n");
                    stack.pop();
                    tmpIdx++;
                }else{
                    if(tmpNum<=n){
                        sb.append("+").append("\n");
                        stack.push(tmpNum);
                    }
                    tmpNum++;
                }
            }
        }
        if(stack.empty()) System.out.println(sb);
        else System.out.println("NO");
    }
}
