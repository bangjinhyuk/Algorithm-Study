import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by bangjinhyuk on 2021/10/26.
 */
public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for(int i=1;i<=n;i++){
            deque.add(i);
        }
        while(deque.size()>1){
            deque.pollFirst();
            if(deque.size()==1) break;
            else{
                int tmp = deque.pollFirst();
                deque.addLast(tmp);
            }
        }
        System.out.println(deque.peek());
    }
}
