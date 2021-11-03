import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/10/12.
 */
public class BOJ_2109 {
    //하기로 정한 강연 -  강의료 오름차순 우선순위 큐
    static PriorityQueue<lecture> applyLectures = new PriorityQueue<>(Comparator.comparingInt(o -> o.p));
    //강연 - 날짜 기한 오름차순, 기한이 같다면 강의료 내림차순 우선순위 큐
    static PriorityQueue<lecture> lectures = new PriorityQueue<>((o1, o2) -> {
        if(o1.q == o2.q) return o2.p-o1.p;
        else return o1.q-o2.q;
    });
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n =  Integer.parseInt(br.readLine());
        int num = n;
        while(n-- >0){
            var st = new StringTokenizer(br.readLine()," ");
            lectures.add(new lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int day = 1, sum = 0;

        for(int i=0;i<num;i++) {
            //현재 날짜와 우선순위 큐에서 꺼낸 날짜 조건이 맞으면 하기로 한 강연 우선순위 큐에 넣기
            if (lectures.peek() != null && lectures.peek().q >= day) {
                sum += Objects.requireNonNull(lectures.peek()).p;
                applyLectures.add(Objects.requireNonNull(lectures.poll()));
                day++;
            }else{
                // 날짜 조건이 맞지 않지만 하기로 한 강연중 가장 단가가 낮은것과 비교하여 현재 선택된것이 단가가 더 높다면 하기로 한 강연에서 단가 낮은것 빼고 선택된거 넣기
                if (applyLectures.peek() != null && applyLectures.peek().p < Objects.requireNonNull(lectures.peek()).p) {
                    sum -= applyLectures.peek().p;
                    sum += lectures.peek().p;
                    applyLectures.poll();
                    applyLectures.add(lectures.poll());
                }else lectures.poll();
            }
        }
        System.out.println(sum);
    }
    static class lecture{
        int p;
        int q;

        public lecture(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
}
