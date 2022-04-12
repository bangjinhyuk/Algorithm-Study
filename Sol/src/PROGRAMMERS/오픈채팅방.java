package PROGRAMMERS;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bangjinhyuk on 2022/04/12.
 */
public class 오픈채팅방 {
    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Map<String,String> userNicknameMap = new HashMap<>();

        List<History> histories = Arrays.stream(record).map(r -> {
            StringTokenizer st = new StringTokenizer(r, " ");
            String method = st.nextToken();
            String uid = st.nextToken();
            if(!method.equals("Leave"))
                userNicknameMap.put(uid,st.nextToken());
            return new History(method,uid);
        }).collect(Collectors.toList());


        String[] answer = histories.stream()
                .filter(h -> !h.method.equals("Change"))
                .map(h -> {
                    if(h.method.equals("Enter")){
                        return userNicknameMap.get(h.uid)+"님이 들어왔습니다.";
                    }
                    else
                        return userNicknameMap.get(h.uid)+"님이 나갔습니다.";
                })
                .toArray(String[]::new);

        Arrays.stream(answer).forEach(System.out::println);
    }
    public static class History{
        String method;
        String uid;

        public History(String method, String uid){
            this.method = method;
            this.uid = uid;
        }
    }
}
