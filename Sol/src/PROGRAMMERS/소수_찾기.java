package PROGRAMMERS;
import java.util.*;
/**
 * Created by bangjinhyuk on 2022/05/02.
 */
public class 소수_찾기 {
    static boolean[] decimal;
    static String numbersS;
    static Set<Integer> result;
    public static void main(String[] args) {
        String numbers = "011";
        numbersS = numbers;
        result = new HashSet<>();
        decimal = new boolean[10000000];
        decimal[0] = true;
        decimal[1] = true;

        getDecimal();
        getResult("", "");
        System.out.println(result.size());

    }

    public static void getResult(String tmp, String check){
        if(check.length() == numbersS.length()){
            if(tmp.length() >0 && !decimal[Integer.parseInt(tmp)]) {
                result.add(Integer.parseInt(tmp));
            }
            return;
        }
        for(int i = 0; i< numbersS.length(); i++){
            if(!check.contains(i +"")){
                getResult(tmp+String.valueOf(numbersS.charAt(i)),check+i);
                getResult(tmp,check+i);
            }
        }
    }


    public static void getDecimal(){
        for(int i = 2; i< decimal.length; i++){
            if(!decimal[i]){
                for(int j = i+i; j< decimal.length; j = j+i){
                    decimal[j] = true;
                }
            }
        }
    }
}
