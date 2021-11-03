import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/12.
 */
public class BOJ_11399 {
    static int [] people;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine()," ");
        people = new int[n];
        for(int i =0;i<n;i++){
             people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);
        int sum = 0,tmp;
        for(int i =0;i<n;i++){
            tmp = people[i];
            people[i] += sum;
            sum += tmp;

        }
        sum = 0;
        for(int i =0;i<n;i++){
            sum += people[i];
        }
        System.out.println(sum);
    }
}
