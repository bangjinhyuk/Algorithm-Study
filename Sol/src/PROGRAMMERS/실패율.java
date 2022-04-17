package PROGRAMMERS;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by bangjinhyuk on 2022/04/17.
 */
public class 실패율 {
    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 4, 2, 4, 3, 3};
        int N = 5;

        Map<Integer, Long> resultMap = Arrays.stream(Arrays.stream(stages).toArray()).mapToObj(i -> i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (int i = 0; i < N; i++) {
            if(Objects.isNull(resultMap.get(i + 1)))
                resultMap.put(i + 1, 0L);
        }
        System.out.println(resultMap);

        int[] arrive = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = i;
            arrive[i] = 0;
            arrive[i] = resultMap.entrySet()
                    .stream()
                    .filter(integerLongEntry -> integerLongEntry.getKey() >= (tmp+1))
                    .map(Map.Entry::getValue)
                    .reduce(0L,Long::sum).intValue();
        }
        Map<Integer, Double> resultFailMap =  new HashMap<>();


        resultMap.keySet().stream().forEach(integer -> {
            if(integer <= N) {
                if(arrive[integer - 1] ==0)
                    resultFailMap.put(integer, 0d);
                else
                    resultFailMap.put(integer, (double) resultMap.get(integer) / arrive[integer - 1]);
            }
        });

        System.out.println(resultFailMap);

        int[] answer = resultFailMap.entrySet()
                .stream()
                .sorted((e1,e2) ->{
                    if(e1.getValue().equals(e2.getValue()))
                        return e1.getKey()-e2.getKey();
                    else
                        return Double.compare(e2.getValue(),e1.getValue());
                })
                .mapToInt(Map.Entry::getKey)
                .toArray();

        Arrays.stream(answer).forEach(System.out::println);



    }
}
