package PROGRAMMERS;
import java.util.*;
import java.util.stream.Collectors;
/**
 * Created by bangjinhyuk on 2022/04/22.
 */
public class 후보키 {
    static List<String> allList;
    public static void main(String[] args) {
        String[][] relation = {{"100","1","aaa","c","ng"},{"200","1","bbb","c","g"},{"300","1","aaa","d","ng"},{"400","2","bbb","d","ng"}};
        List<List<String>> relationList = new ArrayList<>();
        int columnNum = relation[0].length;

        for(int i = 0; i < relation.length; i++ ){
            List<String> tuple = new ArrayList<>();
            for(int j = 0; j < columnNum; j++){
                tuple.add(relation[i][j]);
            }
            relationList.add(tuple);
        }

        allList = new ArrayList<>();
        getAllList(columnNum,1,"");
        System.out.println(allList);


        List<String> answerList = new ArrayList<>();
        for(int i = 0; i < allList.size(); i++){
            int tmp = i;
            long keyCount = relationList.stream().map(tuple ->{
                String s = "";
                for(int j = 0; j< columnNum;j++){
                    if(allList.get(tmp).contains(String.valueOf(j+1))){
                        s += tuple.get(j);
                    }
                }
                return s;
            }).distinct().count();

            if(keyCount == relationList.size())
                answerList.add(allList.get(i));
        }
        answerList = answerList.stream().sorted((s1,s2) -> s1.length() - s2.length()).collect(Collectors.toList());


        List<String> results = new ArrayList<>();

        for (String s : answerList) {

            boolean isCorrect = true;

            for (String result : results) {
                boolean isAnswer = false;
                for (int i = 0; i < result.length(); i++) {
                    if(!s.contains(String.valueOf(result.charAt(i)))) {
                        isAnswer = true;
                        break;
                    }
                }
                if(!isAnswer) {
                    isCorrect = false;
                    break;
                }
            }

            if(isCorrect)
                results.add(s);
        }
        System.out.println(results);
        System.out.println(results.size());
    }

    private static void getAllList(int columnNum, int idx, String tmp) {
        if(idx > columnNum) {
            if(!tmp.equals(""))
                allList.add(tmp);
            return;
        }
        getAllList(columnNum,idx+1,tmp);
        getAllList(columnNum,idx+1,tmp+idx);


    }
}
