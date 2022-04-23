package PROGRAMMERS;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bangjinhyuk on 2022/04/23.
 */
public class 보석_쇼핑 {

    public static void main(String[] args) {
        String[] gems = {"a", "b", "c", "b", "a", "d", "c", "a", "e"};

        Map<String, Integer> jewelryLocationMap = new HashMap<>();

        for(int i = 0; i < gems.length; i++){
            if(!jewelryLocationMap.containsKey(gems[i]))
                jewelryLocationMap.put(gems[i],0);
        }

        Deque<String> window = new LinkedList<>();

        int windowJewelryNum = 0;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int tmpLength = Integer.MAX_VALUE;

        for(int i = 0; i < gems.length; i++){
            if(i == 4)
                System.out.println(i);
            if(window.size()>0 && window.peekLast().equals(gems[i])){
                window.pollLast();
                window.addFirst(gems[i]);
                while(true){
                    if(jewelryLocationMap.get(window.peekLast()) >1){
                        jewelryLocationMap.put(window.peekLast(),jewelryLocationMap.get(window.peekLast())-1);
                        window.pollLast();
                    }else
                        break;
                }
            }else{
                window.addFirst(gems[i]);
                if(jewelryLocationMap.get(gems[i]) ==0){
                    windowJewelryNum++;
                }
                jewelryLocationMap.put(gems[i],jewelryLocationMap.get(gems[i])+1);
            }
            if(windowJewelryNum == jewelryLocationMap.keySet().size() && tmpLength > i -(i-window.size()-1)){
                start = i-(window.size()-1);
                end = i;
                tmpLength = i -(i-window.size()-1);
            }
        }
        System.out.println(start + " " + end);

    }



}

//import java.util.*;
//        import java.util.stream.Collectors;
//class Solution {
//    static Map<String, List<Integer>> jewelryLocationMap;
//    static List<String> jewelryList;
//    static int startIdx;
//    static int endIdx;
//    static int tmpLength;
//    public int[] solution(String[] gems) {
//
//        jewelryLocationMap = new HashMap<>();
//
//        for(int i = 0; i < gems.length; i++){
//            if(!jewelryLocationMap.containsKey(gems[i]))
//                jewelryLocationMap.put(gems[i],new ArrayList<>());
//            jewelryLocationMap.get(gems[i]).add(i);
//        }
//
//        System.out.println(jewelryLocationMap);
//
//        jewelryList = new ArrayList<>(jewelryLocationMap.keySet());
//        tmpLength = Integer.MAX_VALUE;
//        getCases(0,0,0);
//        int[] answer = {startIdx+1,endIdx+1};
//        return answer;
//    }
//    private static void getCases(int idx, int start, int end) {
//        if(idx < jewelryList.size()) {
//            for (Integer integer : jewelryLocationMap.get(jewelryList.get(idx))) {
//                if(idx == 0){
//                    getCases(idx+1,integer,integer);
//                }else{
//                    if(start > integer) {
//                        getCases(idx + 1, integer, end);
//                    }
//                    else if(end < integer)
//                        getCases(idx+1,start,integer);
//                    else
//                        getCases(idx+1,start,end);
//                }
//            }
//        }else{
//            if(end-start < tmpLength){
//                startIdx = start;
//                endIdx = end;
//                tmpLength = end-start;
//            }else if(end-start ==tmpLength && start<startIdx){
//                startIdx = start;
//                endIdx = end;
//                tmpLength = end-start;
//            }
//        }
//    }
//
//}
