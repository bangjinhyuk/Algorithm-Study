package PROGRAMMERS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bangjinhyuk on 2022/04/24.
 */
public class 불량_사용자 {
    static Set<String> result;
    static int banNum;
    static Map<String, List<Integer>> resultMap;
    static List<String> keyList;
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        resultMap = new HashMap<>();
        result = new HashSet<>();
        banNum = banned_id.length;

        for (int j = 0; j<banned_id.length; j++) {
            resultMap.put(banned_id[j]+j,new ArrayList<>());
            for (int k = 0; k<user_id.length; k++) {
                if(banned_id[j].length() == user_id[k].length()){
                    boolean isMatching = true;
                    for(int i = 0; i < banned_id[j].length(); i++){
                        if(!String.valueOf(banned_id[j].charAt(i)).equals("*") && !String.valueOf(banned_id[j].charAt(i)).equals(String.valueOf(user_id[k].charAt(i)))){
                            isMatching = false;
                            break;
                        }
                    }
                    if(isMatching)
                        resultMap.get(banned_id[j]+j).add(k);
                }
            }
        }
        keyList = resultMap.keySet().stream().collect(Collectors.toList());
        getResult(0,"");


        int answer = result.size();
        System.out.println(resultMap);
        System.out.println(result);
        System.out.println(answer);

    }

    private static void getResult(int i, String s) {
        if(i < banNum){
            for (Integer integer : resultMap.get(keyList.get(i))) {
                if(!s.contains(String.valueOf(integer))){
                    getResult(i+1,s+integer);
                }
            }
        }else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            result.add(new String(chars));
        }
    }
}
