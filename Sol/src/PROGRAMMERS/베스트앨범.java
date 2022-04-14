package PROGRAMMERS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bangjinhyuk on 2022/04/14.
 */
public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Map<String, Map<Integer, Integer>> musicMap = new HashMap<>();
        Map<String, Integer> genresMap = new HashMap<>();

        for(int i = 0; i < genres.length ; i++){
            if(!musicMap.containsKey(genres[i])){
                musicMap.put(genres[i], new HashMap<>());
                genresMap.put(genres[i],0);
            }
            musicMap.get(genres[i]).put(i,plays[i]);
            genresMap.put(genres[i],genresMap.get(genres[i])+plays[i]);
        }
        List<String> genresOrder = genresMap.entrySet()
                .stream()
                .sorted((e1,e2) -> e2.getValue()- e1.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> answerList = new ArrayList<>();

        for(String genre : genresOrder){
            musicMap.get(genre).entrySet()
                    .stream()
                    .sorted((e1,e2) -> {
                        if(e2.getValue() == e1.getValue())
                            return e1.getKey() - e2.getKey();
                        return e2.getValue()- e1.getValue();
                    })
                    .limit(2)
                    .forEach(entry -> answerList.add(entry.getKey()));
        }

        Integer[] answer = answerList.toArray(new Integer[answerList.size()]);
        System.out.println(Arrays.toString(Arrays.stream(answer).mapToInt(Integer::intValue).toArray()));
    }
}
