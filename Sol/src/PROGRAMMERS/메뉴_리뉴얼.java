package PROGRAMMERS;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by bangjinhyuk on 2022/04/19.
 */
public class 메뉴_리뉴얼 {
    static List<String> cases;
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        cases = new ArrayList<>();
        for(int i=0; i< orders.length ;i++){
            for(int j = 0; j < course.length; j++){
                char[] chars = orders[i].toCharArray();
                Arrays.sort(chars);
                getAllCases(new String(chars),course[j],"");
            }
        }
        System.out.println(cases.size());

        Map<String, Long> casesMap = cases.stream()
                .map(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                })
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer,Map<String, Long>> resultMap = new HashMap<>();

        casesMap.entrySet().stream().filter(entry -> entry.getValue() >=2).forEach(entry -> {
            if (!resultMap.containsKey(entry.getKey().length()))
                resultMap.put(entry.getKey().length(), new HashMap<>());
            resultMap.get(entry.getKey().length()).put(entry.getKey(), entry.getValue());
        });

        System.out.println(resultMap);

        List<String> result = new ArrayList<>();

        for(int j = 0; j < course.length; j++){
            if(!resultMap.containsKey(course[j]))
                break;
            long max = resultMap.get(course[j]).values().stream().max(Long::compare).orElse(0L);
            resultMap.get(course[j])
                    .entrySet()
                    .stream()
                    .filter(entry -> max == entry.getValue())
                    .forEach(entry -> {
                        result.add(entry.getKey());
                    });
        }
        String[] answer = result.stream().sorted().toArray(String[]::new);


    }

    private static void getAllCases(String order, int i, String s) {
        if(s.length() == i){
            cases.add(s);
        }else{
            for (int j = 0; j < order.length(); j++) {
                getAllCases(order.substring(j+1),i,s+order.charAt(j));
            }
        }
    }
}
