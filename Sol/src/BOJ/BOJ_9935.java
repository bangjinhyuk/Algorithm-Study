import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by bangjinhyuk on 2021/10/28.
 */
public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque  = new LinkedList<>();
        var st = br.readLine();
        var bomb = br.readLine();
        var lastString = String.valueOf(bomb.charAt(bomb.length()-1));
        if(st.length()<bomb.length()) System.out.println(st);
        else{
            for (int i = bomb.length() - 1; i < st.length(); i++) {
                if (String.valueOf(st.charAt(i)).equals(lastString)) {
                    if (deque.size() >= 2) {
                        if (deque.peekLast() > i - bomb.length()) {
                            int end = deque.pollLast();
                            int start = deque.pollLast();
                            if(i - bomb.length() * 2 + 1>=0&&i - bomb.length() * 2 + 1<start) {
                                if ((st.substring(i - bomb.length() * 2 + 1, start) +
                                        st.substring(end + 1, i + 1)).equals(bomb)) {
                                    deque.add(i - bomb.length() * 2 + 1);
                                    deque.add(i);
                                }else{
                                    deque.add(start);
                                    deque.add(end);
                                }
                            }else{
                                deque.add(start);
                                deque.add(end);
                            }
                        } else {
                            if (st.substring(i - bomb.length() + 1, i + 1).equals(bomb)) {
                                deque.add(i - bomb.length() + 1);
                                deque.add(i);
                            }
                        }
                    } else {
                        if (st.substring(i - bomb.length() + 1, i + 1).equals(bomb)) {
                            deque.add(i - bomb.length() + 1);
                            deque.add(i);
                        }
                    }

                }
            }
            var sb = new StringBuilder();
            int startIdx = 0;
            while (!deque.isEmpty()) {
                sb.append(st, startIdx, deque.pollFirst());
                startIdx = deque.pollFirst() + 1;
            }
            if (startIdx < st.length()) sb.append(st, startIdx, st.length());
            if (sb.toString().length() == 0) System.out.println("FRULA");
            else System.out.println(sb);
        }
    }
}
