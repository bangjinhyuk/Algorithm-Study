import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/09/02.
 */
public class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> list  = new ArrayList<>();
        for(int i= 0;i<n;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int i: list) sb.append(i).append("\n");
        System.out.println(sb);
    }
}
