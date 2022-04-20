package PROGRAMMERS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bangjinhyuk on 2022/04/20.
 */
public class 수식_최대화 {
    static List<String> operationList;
    public static void main(String[] args) {

        String expression = "0-1*0-0+0";

        List<Long> integers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(expression, "+|-|*");
        int count = st.countTokens();
        for(int i = 0; i < count; i++){
            integers.add(Long.parseLong(st.nextToken()));
        }
        for(int i = 0; i < expression.length(); i++){
            if(String.valueOf(expression.charAt(i)).equals("+") ||
                    String.valueOf(expression.charAt(i)).equals("-") ||
                    String.valueOf(expression.charAt(i)).equals("*")){
                operators.add(String.valueOf(expression.charAt(i)));
            }
        }
        System.out.println(integers);
        System.out.println(operators);
        operationList = new ArrayList<>();
        getOperatorOrder("+-*", "");
        long answer = 0;
        for (String s : operationList) {
            answer = Math.max(answer, getCalculateResult(s,new ArrayList<>(integers),new ArrayList<>(operators)));
        }

        System.out.println(answer);

    }

    private static long getCalculateResult(String s, List<Long> integers, List<String> operators) {

        for (int i = 0; i < s.length(); i++) {

            String tmp = String.valueOf(s.charAt(i));
            for (int j = 0; j < operators.size(); j++) {
                if(operators.get(j).equals(tmp)){
                    if(tmp.equals("+")) {
                        integers.set(j+1,integers.get(j)+integers.get(j+1));
                        integers.set(j,null);
                    }
                    if(tmp.equals("-")) {
                        integers.set(j+1,integers.get(j)-integers.get(j+1));
                        integers.set(j,null);
                    }
                    if(tmp.equals("*")) {
                        integers.set(j+1,integers.get(j)*integers.get(j+1));
                        integers.set(j,null);
                    }
                }
            }
            integers = integers.stream().filter(Objects::nonNull).collect(Collectors.toList());
            operators = operators.stream().filter(s1 -> !s1.equals(tmp)).collect(Collectors.toList());

        }

        return Math.abs(integers.get(0));
    }

    private static void getOperatorOrder(String operation, String tmp) {
        if(tmp.length() ==3){
            operationList.add(tmp);
            return;
        }
        for(int i = 0; i< operation.length(); i++){
            getOperatorOrder(operation.replace(String.valueOf(operation.charAt(i)),""),tmp+operation.charAt(i));
        }


    }


}
