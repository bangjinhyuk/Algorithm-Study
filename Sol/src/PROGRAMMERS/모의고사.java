package PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/06.
 */
public class 모의고사 {

    public int[] solution(int[] answers) {
        int[] answer = {};
        int [] first = {1,2,3,4,5} ;
        int [] second = {2,1,2,3,2,4,2,5};
        int [] third = {3,3,1,1,2,2,4,4,5,5};
        int [] correct = {0,0,0};
        List<Integer> result  = new ArrayList<>();
        for(int i=0;i<answers.length;i++){
            if(first[i%first.length] == answers[i]) correct[0] ++;
            if(second[i%second.length] == answers[i]) correct[1] ++;
            if(third[i%third.length] == answers[i]) correct[2] ++;
        }

        int max = -1 ;

        for(int i=0;i<3;i++){
            if(correct[i]>max){
                max = correct[i];
                result  = new ArrayList<>();
                result.add(i+1);
            }else if(correct[i]==max){
                result.add(i+1);
            }
        }
        answer = new int [result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }

        return answer;
    }

}
