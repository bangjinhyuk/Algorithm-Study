package PROGRAMMERS;
import java.util.*;
import java.util.regex.*;
/**
 * Created by bangjinhyuk on 2022/04/20.
 */
public class 뉴스_클러스터링 {
    static Map<String, Integer> str1Map;
    static Map<String, Integer> str2Map;
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        str1Map = new HashMap<>();
        str2Map = new HashMap<>();

        getMap(str1,1);
        getMap(str2,2);

        int intersection = 0;
        int union = 0;
        for(String s : str1Map.keySet()){
            if(str2Map.containsKey(s)){
                intersection += Math.min(str1Map.get(s), str2Map.get(s));
                union+= Math.max(str1Map.get(s), str2Map.get(s));
            }
            else
                union+=str1Map.get(s);
        }
        for(String s : str2Map.keySet()){
            if(!str1Map.containsKey(s)){
                union+=str2Map.get(s);
            }
        }

        int answer = 0;
        if(intersection ==0 && union ==0)
            answer =65536;
        else
            answer = (int)Math.floor(((double)intersection/union) * 65536);

        System.out.println(answer);
    }
    public static boolean checkString(String s){
        return Pattern.matches("^[a-z]*$", s);
    }
    public static void getMap(String str, int type){
        Map<String, Integer> tmpMap;
        if(type == 1)
            tmpMap = str1Map;
        else
            tmpMap = str2Map;

        for(int i= 0; i< str.length()-1 ; i++){
            String tmp = str.substring(i,i+2).toLowerCase();
            if(!checkString(tmp))
                continue;
            if(tmpMap.containsKey(tmp))
                tmpMap.put(tmp, tmpMap.get(tmp)+1);
            else
                tmpMap.put(tmp, 1);
        }

    }
}
