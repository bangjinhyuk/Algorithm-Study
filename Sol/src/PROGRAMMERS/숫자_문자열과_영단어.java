package PROGRAMMERS;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bangjinhyuk on 2022/04/14.
 */
public class 숫자_문자열과_영단어 {
    public static void main(String[] args) {
        String s = "one4seveneight";

        Map<String,String> word = new HashMap<>();
        word.put("zero","0");
        word.put("one","1");
        word.put("two","2");
        word.put("three","3");
        word.put("four","4");
        word.put("five","5");
        word.put("six","6");
        word.put("seven","7");
        word.put("eight","8");
        word.put("nine","9");


        for(String w : word.keySet()){
            s = s.replaceAll(w,word.get(w));
        }

        int answer = Integer.parseInt(s);
        System.out.println(answer);
    }
}
