package PROGRAMMERS;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/04/30.
 */
public class 캐시 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for(int i = 0; i< cities.length; i++){
            if(cache.contains(cities[i].toLowerCase())){
                answer++;
                cache.remove(cities[i].toLowerCase());
                cache.add(cities[i].toLowerCase());
            }else{
                if(cache.size()==cacheSize)
                    cache.poll();
                cache.add(cities[i].toLowerCase());
                answer+=5;
            }
        }
        if(cacheSize ==0)
            answer = cities.length*5;

        System.out.println(answer);
    }
}
