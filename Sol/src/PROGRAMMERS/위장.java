package PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/03.
 */
public class 위장 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            List<String> type = new ArrayList<>();

            for(int i = 0;i<clothes.length;i++){
                if(!type.contains(clothes[i][1])) type.add(clothes[i][1]);
            }
            int [] num = new int[type.size()];
            for(int i = 0;i<clothes.length;i++){
                num[type.indexOf(clothes[i][1])]++;
            }
            for(int i:num){
                answer *= (i+1);
            }
            return answer-1;
        }
    }
}
