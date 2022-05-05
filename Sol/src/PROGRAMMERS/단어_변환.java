package PROGRAMMERS;
import java.util.*;
/**
 * Created by bangjinhyuk on 2022/05/05.
 */
public class 단어_변환 {
    static int wordLength;
    static boolean[] checked;
    static String targetS;
    static int result;
    static String[] wordsS;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};


        wordsS = words;
        wordLength = words[0].length();
        checked = new boolean[words.length];
        targetS = target;
        result = Integer.MAX_VALUE;

        getDfs(begin, 0);
        if(result == Integer.MAX_VALUE)
            result = 0;
        System.out.println(result);



    }

    private static void getDfs(String begin, int tmp) {
        if(begin.equals(targetS)){
            result = Math.min(result, tmp);
        }
        else{
            StringBuilder beginSb = new StringBuilder();
            beginSb.append(begin);
            StringBuilder tmpSb;
            for(int i = 0; i < wordLength; i++){
                beginSb.deleteCharAt(i);
                for (int j = 0; j < wordsS.length; j++) {
                    tmpSb = new StringBuilder();
                    tmpSb.append(wordsS[j]);
                    tmpSb.deleteCharAt(i);
                    if(!checked[j] &&  beginSb.toString().equals(tmpSb.toString())){
                        checked[j] = true;
                        getDfs(wordsS[j],tmp+1);
                        checked[j] = false;
                    }
                }
                beginSb = new StringBuilder();
                beginSb.append(begin);
            }
        }
    }
}
