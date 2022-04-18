package PROGRAMMERS;

import java.util.*;

/**
 * Created by bangjinhyuk on 2022/04/18.
 */
public class 키패드_누르기 {
    static String[][] key = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"},{"*","0","#"}};
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        List<Integer> leftKey = Arrays.asList(1,4,7);
        List<Integer> rightKey = Arrays.asList(3,6,9);

        String answer = "";

        HandLocation left = new HandLocation(3,0);
        HandLocation right = new HandLocation(3,2);

        for(int i = 0; i < numbers.length; i++){
            if(leftKey.contains(numbers[i])){
                left = findLocation(numbers[i]);
                answer += "L";
            }else if(rightKey.contains(numbers[i])){
                right = findLocation(numbers[i]);
                answer += "R";
            }else{
                HandLocation tmp = findLocation(numbers[i]);
                double leftHandDistance = Math.abs(left.x-tmp.x) + Math.abs(left.y-tmp.y);
                double rightHandDistance = Math.abs(right.x-tmp.x) + Math.abs(right.y-tmp.y);
                if(leftHandDistance == rightHandDistance){
                    if(hand.equals("left")){
                        left = tmp;
                        answer += "L";
                    }else{
                        right = tmp;
                        answer += "R";
                    }
                }else if(leftHandDistance > rightHandDistance){
                    right = tmp;
                    answer += "R";
                }else{
                    left = tmp;
                    answer += "L";
                }

            }

        }
    }
    public static HandLocation findLocation(int num){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(key[i][j].equals(String.valueOf(num))){
                    return new HandLocation(i,j);
                }
            }
        }
        return null;
    }


    public static class HandLocation{
        int x;
        int y;
        public HandLocation(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
