package PROGRAMMERS;

import java.util.*;
import java.util.function.Function;

/**
 * Created by bangjinhyuk on 2022/04/12.
 */
public class 문자열_압축 {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaa";
        Stack<String> stack;
        Map<Integer,Integer> resultMap = new HashMap<>();
//        if(s.length() == 1)
//            return 1;
        for(int i = 1; i <= s.length()/2; i++){
            stack = new Stack<>();
            int tmp = 1;
            int shortenCount = 0;
            for(int j = 0; j< s.length(); j=j+i){
                if(j+i-1<s.length()) {
                    if(stack.size()>0 && stack.peek().equals(s.substring(j, j + i))){
                        tmp++;
                    }else{
                        stack.push(s.substring(j, j + i));
                        if(tmp != 1) {
                            shortenCount += String.valueOf(tmp).length();
                            System.out.println(tmp);
                        }
                        tmp = 1;
                    }
                }else{
                    stack.push(s.substring(j));
                }
            }
            if(tmp != 1)
                shortenCount += String.valueOf(tmp).length();

            resultMap.put(stack.stream().map(s1 -> s1.length()).reduce(0,Integer::sum)+shortenCount,i);
        }
        int answer = resultMap.keySet().stream().min(Comparator.comparing(x->x)).get();
        System.out.println(answer);

    }
}
