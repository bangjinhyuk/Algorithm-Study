package PROGRAMMERS;

import java.util.Arrays;

/**
 * Created by bangjinhyuk on 2021/11/03.
 */
public class 전화번호_목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Arrays.sort(phone_book);
            for(int i=0;i<phone_book.length-1;i++){
                if(phone_book[i+1].startsWith(phone_book[i])) {
                    answer =false;
                    break;
                }
            }

            return answer;
        }
    }
}
