import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/10/11.
 */
public class BOJ_1931 {
    static List<Conference> conferences = new ArrayList<>();
    static Conference last;
    static int n;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i =0;i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            conferences.add(new Conference(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        conferences.sort((Conference c1, Conference c2) -> {
            if (c1.end == c2.end)
                return c1.start - c2.start;
            return c1.end - c2.end;
        });
        System.out.println(getMaxConference());
    }

    private static int getMaxConference() {
        int result = 1;
        last = conferences.get(0);
        for(int i =1;i<n;i++){
            if(last.end<= conferences.get(i).start){
                last = conferences.get(i);
                result++;
            }
        }

        return result;
    }


    static class Conference{
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
