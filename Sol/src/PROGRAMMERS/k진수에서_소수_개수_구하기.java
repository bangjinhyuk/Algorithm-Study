package PROGRAMMERS;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/04/28.
 */
public class k진수에서_소수_개수_구하기 {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        int p = n;
        int r;
        String result = "";
        while(true){
            r = p%k;
            p = p/k;
            result = r + result;
            if(p == 0)
                break;
        }
        List<Integer> zeroIdx = new ArrayList<>();

        for (int i = 0; i < result.length(); i++) {
            if(String.valueOf(result.charAt(i)).equals("0")){
                zeroIdx.add(i);
            }
        }
        int answer = 0;
        if(zeroIdx.size() == 0){
            if(isPrime(Long.parseLong(result)))
                answer = 1;
        }else{
            int tmpIdx = 0;
            for(int i = 0; i < zeroIdx.size(); i++){
                if(!result.substring(tmpIdx,zeroIdx.get(i)).equals("") &&isPrime(Long.parseLong(result.substring(tmpIdx,zeroIdx.get(i)))))
                    answer++;
                tmpIdx = zeroIdx.get(i)+1;
            }
            if(!result.substring(tmpIdx).equals("") && isPrime(Long.parseLong(result.substring(tmpIdx))))
                answer++;
        }
        System.out.println(answer);
    }
    public static boolean isPrime(long num){
        if(num ==0 ||num==1)
            return false;
        for(int i = 2; i < (int)Math.sqrt(num)+1; i++){
            if(num%i ==0)
                return false;
        }
        return true;
    }
}
