package PROGRAMMERS;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * Created by bangjinhyuk on 2022/04/17.
 */
public class 신고_결과_받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;


        Map<String, Set<String>> userReport = new HashMap<>();

        for(int i = 0; i< id_list.length; i++){
            userReport.put(id_list[i], new HashSet<>());
        }

        for(int i = 0; i< report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i], " ");
            userReport.get(st.nextToken()).add(st.nextToken());
        }
        System.out.println(userReport);
        Map<String, Long> resultMap = userReport.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(resultMap);

        int[] answer = new int[id_list.length];

        for(int i = 0; i< id_list.length; i++){
            answer[i] = 0;
        }
        resultMap.keySet().stream().filter(s -> resultMap.get(s) >= k).forEach(s -> {
            for(int i = 0; i < id_list.length; i++){
                if(userReport.get(id_list[i]).contains(s)){
                    answer[i]++;
                }
            }
        });
        System.out.println(answer[0]);

    }
}
