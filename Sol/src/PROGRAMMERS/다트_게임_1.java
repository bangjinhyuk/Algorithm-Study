package PROGRAMMERS;
import java.util.*;
import java.util.stream.*;
/**
 * Created by bangjinhyuk on 2022/04/17.
 */
public class 다트_게임_1 {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        List<Integer> score = new ArrayList<>();

        for(int i = 0; i< dartResult.length(); i++){
            if(String.valueOf(dartResult.charAt(i)).equals("S") ||
                    String.valueOf(dartResult.charAt(i)).equals("D")||
                    String.valueOf(dartResult.charAt(i)).equals("T")){
                switch(String.valueOf(dartResult.charAt(i))){
                    case "S":
                        score.set(score.size()-1, score.get(score.size()-1));
                        break;
                    case "D":
                        score.set(score.size()-1, score.get(score.size()-1) * score.get(score.size()-1));
                        break;
                    case "T":
                        score.set(score.size()-1, score.get(score.size()-1) * score.get(score.size()-1) * score.get(score.size()-1));
                        break;
                }
            }
            else if(String.valueOf(dartResult.charAt(i)).equals("*") ||
                    String.valueOf(dartResult.charAt(i)).equals("#")){
                switch(String.valueOf(dartResult.charAt(i))){
                    case "*":
                        if(score.size()-1 == 0)
                            score.set(score.size()-1, score.get(score.size()-1) * 2);
                        else{
                            score.set(score.size()-1, score.get(score.size()-1) * 2);
                            score.set(score.size()-2, score.get(score.size()-2) * 2);
                        }
                        break;
                    case "#":
                        score.set(score.size()-1, score.get(score.size()-1) * -1);
                        break;

                }
            }else{
                if(i+1 < dartResult.length() && dartResult.charAt(i+1) > 47 && dartResult.charAt(i+1) < 58){
                    score.add(Integer.parseInt(String.valueOf(dartResult.charAt(i)) + String.valueOf(dartResult.charAt(i+1))));
                    i++;
                }else
                    score.add(Integer.parseInt(String.valueOf(dartResult.charAt(i))));
            }

        }
        score.forEach(i -> System.out.println(i));
        int answer = score.stream().reduce(0,Integer::sum);
    }
}
