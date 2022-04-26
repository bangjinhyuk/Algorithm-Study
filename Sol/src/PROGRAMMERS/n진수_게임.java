package PROGRAMMERS;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/04/26.
 */
public class n진수_게임 {
    static int nS;
    static Map<Integer, String> alphabet;
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        nS = n;
        alphabet = new HashMap<>();
        alphabet.put(10,"A");
        alphabet.put(11,"B");
        alphabet.put(12,"C");
        alphabet.put(13,"D");
        alphabet.put(14,"E");
        alphabet.put(15,"F");
        List<String> result = new ArrayList<>();
        int tmpNum = 0;
        int tmpPerson = 0;
        List<String> tmpList;
        while(true){
            tmpList = getNum(tmpNum);
            boolean isEnd = false;
            for(int i = tmpList.size()-1; i >=0; i--){
                tmpPerson++;
                int tmp = tmpPerson%m;
                if(tmp == 0)
                    tmp = m;
                if(tmp == p)
                    result.add(tmpList.get(i));
                if(result.size() == t){
                    isEnd = true;
                    break;
                }
            }
            if(isEnd)
                break;
            tmpNum++;
        }
        System.out.println(result);
        String answer = "";
        for(int i = 0; i < result.size(); i++){
            answer += result.get(i);
        }
        System.out.println(answer);
    }
    public static List<String> getNum(int tmpNum){
        int q = tmpNum;
        int n;
        List<String> numList = new ArrayList<>();
        while(true){
            n  = q%nS;
            q  = q/nS;
            if(n >=10)
                numList.add(alphabet.get(n));
            else
                numList.add(String.valueOf(n));
            if(q==0)
                break;
        }
        return numList;
    }
}
