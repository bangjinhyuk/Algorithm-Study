package PROGRAMMERS;

import java.util.*;
import java.util.stream.*;

/**
 * Created by bangjinhyuk on 2022/04/21.
 */
public class 튜플 {
    public static void main(String[] args) {

        String s ="{{2},{2,1},{2,1,3},{2,1,3,4}}";
        s = s.substring(1,s.length()-1).replaceAll("\\{","");

        List<List<Integer>> elements = new ArrayList<>();

        String tmp = "";
        List<Integer> element = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(!String.valueOf(s.charAt(i)).equals(",") && !String.valueOf(s.charAt(i)).equals("}")){
                tmp += String.valueOf(s.charAt(i));
            }else if(String.valueOf(s.charAt(i)).equals(",") && String.valueOf(s.charAt(i-1)).equals("}")){
                continue;
            }else if(String.valueOf(s.charAt(i)).equals(",") && !String.valueOf(s.charAt(i-1)).equals("}")){
                element.add(Integer.parseInt(tmp));
                tmp = "";
            }else{
                element.add(Integer.parseInt(tmp));
                tmp = "";
                elements.add(element);
                element = new ArrayList<>();
            }
        }
        elements = elements.stream().sorted((l1,l2) -> l1.size()-l2.size()).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        int[] answer = new int[elements.size()];
        for(int i = 0; i< elements.size(); i++){
            elements.get(i).removeAll(resultList);
            resultList.add(elements.get(i).get(0));
            answer[i] = elements.get(i).get(0);
        }

        System.out.println(answer);
    }
}
