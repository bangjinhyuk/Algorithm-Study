package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/10/30.
 */
public class APC_6 {
    static String [] word;
    static int result = 0;
    static List<Index> indexList;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        word = new String[n];
        for(int i  = 0;i<n;i++){
            word[i] = br.readLine();
        }
        Arrays.sort(word);
        String back = "";
        indexList = new ArrayList<>();
        int i = 0;
        for(String s: word){
            if (!String.valueOf(s.charAt(0)).equals(back)) {
                System.out.println(i);
            }
            back = String.valueOf(s.charAt(0));
            i++;
        }
        for(Index oi : indexList){
            System.out.println(oi.idx);
            System.out.println(oi.endIdx);
            System.out.println(oi.start);
        }
        var code = br.readLine();
        getcode(code,0);
        System.out.println(result);
    }

    private static void getcode(String code, int i) {
        if(code.equals("")&& i ==3) result++;
        else if(i>3) return;
        else{
            for(Index oi : indexList){
                if(oi.start.equals(String.valueOf(code.charAt(0)))){
                    if(oi.endIdx!=0){
                        for(int j = oi.idx;j<oi.endIdx;j++){
                            if(code.startsWith(word[j])) {
                                System.out.println("code="+ code);
                                System.out.println("word[j]="+ word[j]);
                                System.out.println("code.substring(word[j].length())="+ code.substring(word[j].length()));
                                System.out.println("i + 1"+ i + 1);
                                getcode(code.substring(word[j].length()), i + 1);
                            }
                        }
                    }else{
                        for(int j = oi.idx;j< word.length;j++){
                            if(code.startsWith(word[j])) getcode(code.substring(word[j].length()),i+1);
                        }
                    }
                }
            }
        }

    }
    static class Index{
        String start;
        int idx;
        int endIdx = 0;

        public Index(String start, int idx) {
            this.start = start;
            this.idx = idx;
        }
    }
}
