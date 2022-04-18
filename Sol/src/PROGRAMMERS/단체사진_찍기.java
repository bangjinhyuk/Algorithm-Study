package PROGRAMMERS;

import java.util.*;

/**
 * Created by bangjinhyuk on 2022/04/19.
 */
public class 단체사진_찍기 {
    static List<String> cases;
    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"};
        int n = 2;
        int answer = 0;
        cases  = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("A");
        q.offer("C");
        q.offer("F");
        q.offer("J");
        q.offer("M");
        q.offer("N");
        q.offer("R");
        q.offer("T");

        getCases(q, "");

        String[] condition1 = new String[n*2];
        String[] condition2 = new String[n];
        int[] condition3 = new int[n];


        for(int i = 0; i< n; i++){
            condition1[i*2] = String.valueOf(data[i].charAt(0));
            condition1[i*2+1] = String.valueOf(data[i].charAt(2));
            condition2[i] = String.valueOf(data[i].charAt(3));
            condition3[i] = Integer.parseInt(String.valueOf(data[i].charAt(4)));
        }

        for(int i = 0; i< cases.size(); i++){
            Map<String,Integer> tmpMap = new HashMap<>();
            for(int j = 0; j < 8; j++){
                tmpMap.put(String.valueOf(cases.get(i).charAt(j)),j);
            }
            boolean flag = true;
            for(int j = 0; j < n; j++){
                if(condition2[j].equals("=") && Math.abs(tmpMap.get(condition1[j*2])-tmpMap.get(condition1[j*2+1]))-1 == condition3[j]){
                    continue;
                }else if(condition2[j].equals("<") && Math.abs(tmpMap.get(condition1[j*2])-tmpMap.get(condition1[j*2+1]))-1< condition3[j]){
                    continue;
                }else if(condition2[j].equals(">") && Math.abs(tmpMap.get(condition1[j*2])-tmpMap.get(condition1[j*2+1]))-1 > condition3[j]){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        System.out.println(answer);

    }
    public static void getCases(Queue<String> people, String tmpResult){
        if(tmpResult.length() == 8){
            cases.add(tmpResult);
            return;
        }
        for(int i = 0; i < people.size(); i++){
            String tmpString = people.poll();
            getCases(people, tmpResult+tmpString);
            people.offer(tmpString);
        }
    }
}
