package PROGRAMMERS;

/**
 * Created by bangjinhyuk on 2022/04/21.
 */

import java.util.*;
import java.util.stream.*;

public class 순위_검색 {
    /*
     * 두번째 풀이 Stream 사용 정확도 통과, 효율성 전부 불통
     * 정확성: 40.0
     * 효율성: 0.0
     * 합계: 40.0 / 100.0
     */
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        List<Data> dataList = new ArrayList<>();

        for(int i = 0; i < info.length; i++){
            StringTokenizer st = new StringTokenizer(info[i]," ");
            dataList.add(new Data(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken())));
        }
        dataList = dataList
                .stream()
                .sorted(Comparator.comparing(Data::getScore,Comparator.reverseOrder()))
                .collect(Collectors.toList());

        int[] answer = new int[query.length];

        for(int i = 0; i < query.length; i++){
            String replaceQuery = query[i].replaceAll(" and","");
            StringTokenizer st = new StringTokenizer(replaceQuery," ");
            String language = st.nextToken();
            String job = st.nextToken();
            String career = st.nextToken();
            String food = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            answer[i] =0;
            for (Data data : dataList) {
                if(data.getScore() <score)
                    break;
                if(!language.equals("-") && !language.equals(data.getLanguage()))
                    continue;
                if(!job.equals("-") && !job.equals(data.getJob()))
                    continue;
                if(!career.equals("-") && !career.equals(data.getCareer()))
                    continue;
                if(!food.equals("-") && !food.equals(data.getFood()))
                    continue;
                answer[i]++;
            }
            System.out.println(answer[i]);
        }
    }
    public static class Data{
        String language;
        String job;
        String career;
        String food;
        int score;

        public Data(String language, String job, String career, String food, int score) {
            this.language = language;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
        }

        public String getLanguage() {
            return language;
        }

        public String getJob() {
            return job;
        }

        public String getCareer() {
            return career;
        }

        public String getFood() {
            return food;
        }

        public int getScore() {
            return score;
        }
    }
}


/*
 * 첫번째 풀이 MAP만 사용 정확도 통과, 효율성 3,4 불통
 * 정확성: 40.0
 * 효율성: 29.8
 * 합계: 69.8 / 100.0
 */

//class Solution {
//    //          언어          직군          경력       소울푸드       점수들
//    static Map<String, Map<String, Map<String, Map<String, List<Integer>>>>> scoreMap;
//    static Map<String, Integer> maxMap;
//    public int[] solution(String[] info, String[] query) {
//        scoreMap= new HashMap<>();
//        maxMap = new HashMap<>();
//        String language;
//        String job;
//        String career;
//        String food;
//        int score;
//        for(int i = 0; i < info.length; i++){
//            StringTokenizer st = new StringTokenizer(info[i]," ");
//            language = st.nextToken();
//            job = st.nextToken();
//            career = st.nextToken();
//            food = st.nextToken();
//            score = Integer.parseInt(st.nextToken());
//
//            if(!scoreMap.containsKey(language))
//                scoreMap.put(language, new HashMap<>());
//            if(!scoreMap.get(language).containsKey(job))
//                scoreMap.get(language).put(job, new HashMap<>());
//            if(!scoreMap.get(language).get(job).containsKey(career))
//                scoreMap.get(language).get(job).put(career, new HashMap<>());
//            if(!scoreMap.get(language).get(job).get(career).containsKey(food))
//                scoreMap.get(language).get(job).get(career).put(food, new ArrayList<>());
//            scoreMap.get(language).get(job).get(career).get(food).add(score);
//            maxMap.put(language,Math.max(maxMap.getOrDefault(language,0),score));
//
//        }
//        // System.out.println(scoreMap);
//        // System.out.println(maxMap);
//        int[] answer = new int[query.length];
//
//        for(int i = 0; i < query.length; i++){
//            String replaceQuery = query[i].replaceAll(" and","");
//            StringTokenizer st = new StringTokenizer(replaceQuery," ");
//            language = st.nextToken();
//            job = st.nextToken();
//            career = st.nextToken();
//            food = st.nextToken();
//            score = Integer.parseInt(st.nextToken());
//            answer[i] = getResult(language, job, career, food, score);
//
//
//        }
//
//        return answer;
//    }
//    public static int getResult(String language, String job, String career, String food, int targetScore){
//        //언어
//        List<Map<String, Map<String, Map<String, List<Integer>>>>> languageList = new ArrayList<>();
//        if(language.equals("-")){
//            scoreMap.entrySet().forEach(entry -> {
//                if(maxMap.getOrDefault(entry.getKey(),0)>=targetScore)
//                    languageList.add(entry.getValue());
//            });
//        }else{
//            if(scoreMap.containsKey(language))
//                languageList.add(scoreMap.get(language));
//        }
//
//        //직군
//        List<Map<String, Map<String, List<Integer>>>> jobList = new ArrayList<>();
//        if(job.equals("-")){
//            for(Map<String, Map<String, Map<String, List<Integer>>>> languageMap : languageList){
//                if(Objects.nonNull(languageMap))
//                    languageMap.values().forEach(map -> jobList.add(map));
//            }
//        }else{
//            for(Map<String, Map<String, Map<String, List<Integer>>>> languageMap : languageList){
//                if(languageMap.containsKey(job))
//                    jobList.add(languageMap.get(job));
//            }
//        }
//
//        //경력
//        List<Map<String, List<Integer>>> careerList = new ArrayList<>();
//        if(career.equals("-")){
//            for(Map<String, Map<String, List<Integer>>> jobMap : jobList){
//                if(Objects.nonNull(jobMap))
//                    jobMap.values().forEach(map -> careerList.add(map));
//            }
//        }else{
//            for(Map<String, Map<String, List<Integer>>> jobMap : jobList){
//                if(jobMap.containsKey(career))
//                    careerList.add(jobMap.get(career));
//            }
//        }
//
//        //소울푸드
//        List<List<Integer>> foodList = new ArrayList<>();
//        if(food.equals("-")){
//            for(Map<String, List<Integer>> careerMap : careerList){
//                if(Objects.nonNull(careerMap))
//                    careerMap.values().forEach(map -> foodList.add(map));
//            }
//        }else{
//            for(Map<String, List<Integer>> careerMap : careerList){
//                // System.out.println(food);
//                // System.out.println(careerMap);
//                if(careerMap.containsKey(food))
//                    foodList.add(careerMap.get(food));
//            }
//        }
//        // System.out.println(targetScore);
//        // System.out.println(foodList);
//
//        int result = 0;
//        // foodList.stream().flatMap(Collection::stream).filter(i->i>=targetScore&&i!=null).count();
//
//        for(List<Integer> list : foodList){
//            if(list != null){
//                for(int num : list)
//                    if(num >= targetScore)
//                        result++;
//            }
//        }
//        return result;
//
//
//    }
//}