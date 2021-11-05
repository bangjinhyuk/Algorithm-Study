package PROGRAMMERS;

/**
 * Created by bangjinhyuk on 2021/11/04.
 */
public class 타겟_넘버 {
    class Solution {
        static int starget;
        static int result =0;
        static int[] snumbers;

        public int solution(int[] numbers, int target) {
            int answer = 0;
            snumbers = numbers;
            starget = target;
            getTarget(0,0);
            answer = result;
            return answer;
        }
        public void getTarget(int idx, int sum){
            if(idx == snumbers.length){
                if(sum ==starget) result++;
            }else{
                getTarget(idx+1,sum+snumbers[idx]);
                getTarget(idx+1,sum-snumbers[idx]);
            }
        }
    }
}
