import java.io.*;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/09/22.
 */
public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        List<word> words = new ArrayList<>();
        for(int i=0; i<n; i++){
            String tempWord =  br.readLine();
            if(!words.contains(new word(tempWord))){
                words.add(new word(tempWord));
            }
        }
        Collections.sort(words);
        String prev = "";
        for(word w : words){
            if (!prev.equals(w.w)){
                sb.append(w.w).append("\n");
                prev = w.w;
            }
        }
        System.out.println(sb);
    }

    public static class word implements Comparable<word>{
        private String w;

        public word(String w) {
            this.w = w;
        }

        @Override
        public int compareTo(word o) {
            if(this.w.length()> o.w.length()) return 1;
            else if(this.w.length() == o.w.length()) {
                for(int i=0; i<o.w.length(); i++){
                    if(this.w.charAt(i)>o.w.charAt(i)) return 1;
                    else if (this.w.charAt(i)<o.w.charAt(i)) return -1;
                }
                return -1;
            }else return -1;
        }
    }
}
