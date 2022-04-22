package PROGRAMMERS;
import java.util.*;
import java.util.stream.Collectors;
/**
 * Created by bangjinhyuk on 2022/04/22.
 */
public class 셔틀버스 {
    public static void main(String[] args) {

        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        Map<Integer, Integer> timeCountMap = new HashMap<>();
        List<Integer> tableList = new ArrayList<>();
        for(int i = 0; i< timetable.length; i++){
            StringTokenizer st = new StringTokenizer(timetable[i],":");
            int time = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            tableList.add(time);
        }
        Collections.sort(tableList);

        int busStartTime = 540;
        int lastCrew = 0;
        for(int i = 0; i<n ; i++){
            timeCountMap.put(busStartTime,m);
            busStartTime+=t;
        }
        List<Integer> busTimeKey = timeCountMap.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer crewTime : tableList) {
            for (Integer busTime : busTimeKey) {
                if(timeCountMap.get(busTime) > 0 && crewTime <=busTime){
                    lastCrew = crewTime;
                    timeCountMap.put(busTime,timeCountMap.get(busTime)-1);
                    break;
                }
            }
        }
        int answerInt = 0;
        if(timeCountMap.get(busTimeKey.get(busTimeKey.size()-1))==0){
            answerInt = lastCrew-1;
        }else{
            answerInt = busTimeKey.get(busTimeKey.size()-1);
        }

        String answer = String.format("%02d", answerInt/60) + ":" + String.format("%02d", answerInt%60);
        System.out.println(answer);
    }
}
