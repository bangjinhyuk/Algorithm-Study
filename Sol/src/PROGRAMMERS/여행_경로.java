package PROGRAMMERS;

import java.util.*;

/**
 * Created by bangjinhyuk on 2022/05/05.
 */
public class 여행_경로 {
    static String[][] ticketsS;
    static String result;
    static boolean[] checked;
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        ticketsS = tickets;
        result = "";
        checked = new boolean[tickets.length];
        getDfs("",0, "");
        StringTokenizer st = new StringTokenizer(result, "-");
        List<String> resultList = new ArrayList<>();
        while(st.hasMoreTokens()){
            resultList.add(st.nextToken());
        }
        String[] answer = resultList.stream().toArray(String[]::new);
        for (String s : answer) {
            System.out.println(s);
        }
    }

    private static void getDfs(String tmp,int tmpNum, String resultS) {
        if(tmpNum == ticketsS.length){
            resultS+= "-"+tmp;
            if(result.equals(""))
                result = resultS;
            else if(resultS.compareTo(result) < 0)
                result = resultS;
        }else{
            for(int i = 0; i < ticketsS.length; i++){
                if(tmp.equals("")){
                    if(ticketsS[i][0].equals("ICN")) {
                        checked[i] = true;
                        getDfs(ticketsS[i][1], tmpNum + 1, resultS + ticketsS[i][0]);
                        checked[i] = false;
                    }
                }else{
                    if(!checked[i] && ticketsS[i][0].equals(tmp)){
                        checked[i] = true;
                        getDfs(ticketsS[i][1],tmpNum+1,resultS +"-"+ticketsS[i][0]);
                        checked[i] = false;
                    }
                }
            }
        }

    }

}
