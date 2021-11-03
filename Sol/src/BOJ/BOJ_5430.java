import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/27.
 */
public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());
        var sb =new StringBuilder();
        Deque<Integer> deque;
        for(int i = 0;i<t;i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            arr = arr.replaceAll("\\[","").replaceAll("]","");
            var st = new StringTokenizer(arr,",");
            deque = new LinkedList<>();

            for(int j = 0;j<n;j++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            //뒤집기에 따른 탐색 방향 true 앞, false 뒤
            boolean frontOrBack = true;
            for(int j=0;j<p.length();j++){
                //R일때 방향 변경
                if(String.valueOf(p.charAt(j)).equals("R")) {
                    frontOrBack = !frontOrBack;
                }
                //방향에 따라 비어있지 않다면 제거
                else{
                    if(deque.isEmpty()) {
                        sb.append("error").append("\n");
                        break;
                    }
                    if(frontOrBack){
                        deque.pollFirst();
                    }else deque.pollLast();
                }
                //출력 방향 고려
                if(j==p.length()-1){
                    sb.append("[");
                    while(deque.size()>0){
                        if(frontOrBack){
                            if(deque.size()>1) sb.append(deque.pollFirst()).append(",");
                            else sb.append(deque.pollFirst());
                        }
                        else{
                            if(deque.size()>1) sb.append(deque.pollLast()).append(",");
                            else sb.append(deque.pollLast());
                        }
                    }
                    sb.append("]").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
