import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/10/26.
 */
public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        Deque<Document> documents;
        for(int i = 0;i<t;i++){
            var st = new StringTokenizer(br.readLine()," ");
            var n = Integer.parseInt(st.nextToken());
            var m = Integer.parseInt(st.nextToken());
            documents = new LinkedList<>();
            st = new StringTokenizer(br.readLine()," ");

            for(int j=0;j<n;j++){
                if(j == m) documents.add(new Document(Integer.parseInt(st.nextToken()),true));
                else documents.add(new Document(Integer.parseInt(st.nextToken()),false));
            }
            int result = 1;
            int tmp, max;
            boolean end = false;

            while(documents.size()>0){
                tmp = documents.peekFirst().num;
                max = tmp;
                for(int j = 0;j<documents.size();j++){
                    if(documents.peekFirst().num>max) max = documents.peekFirst().num;
                    documents.addLast(documents.pollFirst());
                }
                for(int j = 0;j<documents.size();j++){
                    if(max == documents.peekFirst().num){
                        if (documents.peekFirst().check) {
                            sb.append(result).append("\n");
                            end = true;
                            break;
                        }else documents.pollFirst();
                        result++;
                        break;
                    }else documents.add(documents.pollFirst());
                }
                if(end) break;
            }
        }
        System.out.println(sb);
    }
    static class Document{
        int num;
        boolean check;

        public Document(int num, boolean check) {
            this.num = num;
            this.check = check;
        }
    }
}
