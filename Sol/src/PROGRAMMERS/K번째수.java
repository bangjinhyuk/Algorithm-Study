package PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by bangjinhyuk on 2022/04/14.
 */
public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        List<Integer> answerList = new ArrayList<>();

        Arrays.asList(commands).stream()
                .forEach(ints -> {
                    List<Integer> list = IntStream.range(0,array.length)
                            .mapToObj(i -> array[i])
                            .skip(ints[0]-1)
                            .limit(ints[1]-ints[0]+1)
                            .sorted()
                            .collect(Collectors.toList());
                    answerList.add(list.get(ints[2]-1));
                });
        int[] answer = answerList.stream().mapToInt(i ->i).toArray();
        System.out.println(Arrays.toString(answer));
    }
}
