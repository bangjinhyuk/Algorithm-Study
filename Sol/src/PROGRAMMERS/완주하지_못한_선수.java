package PROGRAMMERS;


import java.util.Arrays;

/**
 * Created by bangjinhyuk on 2021/11/03.
 */
public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = new String[3];
        participant[0] = "a";
        participant[1] = "b";
        participant[2] = "c";
        String[] completion = new String[2];
        completion[0] = "c";
        completion[1] = "b";
        Solution solutions = new Solution();
        System.out.println(solutions.solution(participant,completion));

    }
    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Arrays.sort(participant);
            Arrays.sort(completion);
            for(int i=0;i<completion.length;i++){
                if(!participant[i].equals(completion[i])) {
                    answer = participant[i];
                    break;
                }
            }
            if(answer.equals("")) answer = participant[participant.length-1];
            return answer;
        }
    }
}
