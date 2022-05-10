package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/05/10.
 */
public class BOJ_15654 {
    static List<Integer> numbers;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);
        print("","",0);
    }

    private static void print(String visit, String tmp, int select) {
        if(select >= m) {
            System.out.println(tmp);
            return;
        }
        if(visit.length() == n)
            return;
        for (int i = 0; i < n; i++) {
            if(!visit.contains(String.valueOf(i))) {
                print(visit + i,tmp + numbers.get(i)+ " ", select+1);
            }
        }

    }
}
