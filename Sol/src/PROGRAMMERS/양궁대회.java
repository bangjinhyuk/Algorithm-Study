package PROGRAMMERS;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/04/26.
 */
public class 양궁대회 {
    static int[] infoS;
    static Map<Integer,Integer> tmpLion;
    static int nS;
    static int max;
    public static void main(String[] args) {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        tmpLion = new HashMap<>();
        infoS = info;
        nS = n;
        max = 0;
        getResult(0, new HashMap<>(), 0);
//        if(max == 0)
//            return new int[] {-1};
        int[] answer = new int[11];
        for(int i = 0; i< 11; i++){
            answer[i] = tmpLion.get(10-i);
        }
        System.out.println(answer);
    }
    public static void getResult(int idx, Map<Integer,Integer> tmpMap, int tmp){
        if(idx == 10){
            tmpMap.put(10-idx,nS - tmp);
            int result = getMatchResult(tmpMap);
            if(max <= result && result != 0){
                if(max == result&& isMaxResult(tmpMap)){
                    tmpLion = new HashMap<>(tmpMap);
                }else if(max < result){
                    max = result;
                    tmpLion = new HashMap<>(tmpMap);
                }
            }

        }else{
            tmpMap.put(10-idx,0);
            getResult(idx+1, tmpMap, tmp);
            if(infoS[idx]+1 + tmp <= nS){
                tmpMap.put(10-idx,infoS[idx]+1);
                getResult(idx+1, tmpMap, tmp+infoS[idx]+1);
            }
        }

    }
    public static int getMatchResult(Map<Integer,Integer> tmpMap){
        int apeach = 0;
        int lion = 0;
        for(int i = 0; i < 10; i++){
            if(infoS[i] >= tmpMap.get(10-i) && infoS[i] != 0){
                apeach += 10-i;
            }else if(infoS[i] < tmpMap.get(10-i)){
                lion += 10-i;
            }
        }
        return lion-apeach;
    }
    public static boolean isMaxResult(Map<Integer,Integer> tmpMap){
        for(int i = 0; i < 11; i++){
            if(tmpMap.get(i)>tmpLion.get(i))
                return true;
            if(tmpMap.get(i)<tmpLion.get(i))
                return false;
        }
        return false;
    }

}
