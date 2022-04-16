package PROGRAMMERS;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Created by bangjinhyuk on 2022/04/16.
 */
public class 추석_트래픽_1 {
    static int max = 0;
    public static void main(String[] args) {

        String[] lines = {
        "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };
        List<Log> logs = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            logs.add(new Log(lines[i]));
        }

        for(int i = lines.length-1; i >= 0; i--){
            long tmpStartTime = logs.get(i).start;
            long tmpEndTime = logs.get(i).end;
            int resultStart = 0;
            int resultEnd = 0;
            for(int j = lines.length-1; j >= 0; j--){
                if(j>i){
                    if(tmpEndTime>= logs.get(j).start){
                        resultEnd++;
                    }
                }else if(logs.get(j).end>tmpEndTime-1000){
                    resultEnd++;
                }

                if(j>i){
                    if(tmpStartTime>= logs.get(j).start){
                        resultStart++;
                    }
                }else if(logs.get(j).end>tmpStartTime-1000 && logs.get(j).start<=tmpStartTime){
                    resultStart++;
                }

            }
            max =  Math.max(max,Math.max(resultStart,resultEnd));

        }

        int answer = max;
        System.out.println(answer);
    }
    public static class Log{
        long start;
        long end;
        long duration;

        public Log(String line){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            StringTokenizer st = new StringTokenizer(line, " ");
            this.end =  LocalDateTime
                    .parse(st.nextToken().replace("s","") + " " + st.nextToken() , formatter)
                    .atZone(ZoneId.systemDefault())
                    .toInstant()
                    .toEpochMilli();
            duration = (long)(Double.parseDouble(st.nextToken().replace("s",""))* 1000);
            start = this.end - duration +1;
        }
    }
}
