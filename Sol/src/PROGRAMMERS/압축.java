package PROGRAMMERS;
import java.util.*;
/**
 * Created by bangjinhyuk on 2022/05/01.
 */
public class 압축 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        Map<String, Integer> dictionary = new HashMap<>();

        for(int i = 65; i<= 90; i++){
            dictionary.put(String.valueOf((char)i), i-64);
        }
        List<Integer> result = new ArrayList<>();
        int tmp = 27;
        for(int i = 0; i < msg.length(); i++){
            for(int j = i+1; j <= msg.length(); j++ ){
                if(j+1 > msg.length()){
                    result.add(dictionary.get(msg.substring(i,j)));
                    i = j;
                }else{
                    if(!dictionary.containsKey(msg.substring(i,j+1))){
                        result.add(dictionary.get(msg.substring(i,j)));
                        dictionary.put(msg.substring(i,j+1), tmp);
                        i = j-1;
                        tmp++;
                        break;
                    }
                }
            }
        }


        int[] answer = new int[result.size()];

        for(int i = 0; i< result.size(); i++){
            answer[i] = result.get(i);
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
